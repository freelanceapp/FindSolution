package com.semicode.findsolution.mvp.activtyConfirmationCode;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.semicode.findsolution.R;
import com.semicode.findsolution.share.Common;
import com.semicode.findsolution.ui.ConfirmationCodeActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ActivityConfirmationCodePresenter {
    private Context context;
    private ActivityConfirmationCodeView view;
    private String phone_code = "", phone = "";
    private CountDownTimer countDownTimer;
    private FirebaseAuth mAuth;
    private String verificationId;
    private String smsCode = "";
    private ConfirmationCodeActivity activity;
    private String lang;

    public ActivityConfirmationCodePresenter(Context context, ActivityConfirmationCodeView view
            , String phone_code, String phone) {
        this.context = context;
        this.activity = (ConfirmationCodeActivity) context;
        this.view = view;
        this.phone_code = phone_code;
        this.phone = phone;
        mAuth = FirebaseAuth.getInstance();

        sendSmsCode();
    }

    private void sendSmsCode() {
        startCounter();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                smsCode = phoneAuthCredential.getSmsCode();
                checkValidCode(smsCode);
            }

            @Override
            public void onCodeSent(@NonNull String verification_id, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(verification_id, forceResendingToken);
                ActivityConfirmationCodePresenter.this.verificationId = verification_id;
                Log.e("verification_id", verification_id);
            }


            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

                if (e.getMessage() != null) {
                    view.onCodeFailed(e.getMessage());
                } else {
                    view.onCodeFailed(context.getString(R.string.failed));

                }
            }
        };

        PhoneAuthProvider.getInstance()
                .verifyPhoneNumber(
                        phone_code + phone,
                        120,
                        TimeUnit.SECONDS,
                        activity,
                        mCallBack

                );


    }

    public void checkValidCode(String code) {
        ProgressDialog dialog = Common.createProgressDialog(context, context.getString(R.string.wait));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();

        if (verificationId != null) {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
            mAuth.signInWithCredential(credential)
                    .addOnSuccessListener(authResult -> {
                        dialog.dismiss();
                        login();
                    }).addOnFailureListener(e -> {
                dialog.dismiss();
                if (e.getMessage() != null) {
                    try {
                        view.onCodeFailed(e.getMessage());

                    } catch (Exception ex) {

                    }
                } else {
                    view.onCodeFailed(context.getString(R.string.failed));

                }
            });
        } else {
            sendSmsCode();
        }

    }

    private void login() {
        view.onLogin();
    }

    private void startCounter() {
        countDownTimer = new CountDownTimer(120000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) ((millisUntilFinished / 1000) / 60);
                int seconds = (int) ((millisUntilFinished / 1000) % 60);

                String time = String.format(Locale.ENGLISH, "%02d:%02d", minutes, seconds);
                view.onCounterStarted(time);


            }

            @Override
            public void onFinish() {
                view.onCounterFinished();


            }
        };

        countDownTimer.start();
    }

    public void resendCode() {
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        sendSmsCode();
    }

    public void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
