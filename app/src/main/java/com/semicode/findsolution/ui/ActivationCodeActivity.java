package com.semicode.findsolution.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raycoarana.codeinputview.OnCodeCompleteListener;
import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.ActivityConfirmationCodeBinding;

import java.util.concurrent.TimeUnit;


public class ActivationCodeActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityConfirmationCodeBinding binding;
    private FirebaseAuth mAuth;
    DatabaseReference mRef;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;


    private String phoneNumber, mVerificationId, mCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmationCodeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference().child("User");
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

                signInWithPhoneAuthCredential(credential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                if (e instanceof FirebaseAuthInvalidCredentialsException) {

                }

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {

                mVerificationId = verificationId;

            }
        };
        phoneNumber = "+2" + getIntent().getStringExtra("PHONE_NUMBER");
        binding.activityConfirmationCodeTvNumber.setText(phoneNumber);
        startPhoneNumberVerification(phoneNumber);
        binding.activityConfirmationCodeBtnConfirm.setOnClickListener(this);

        binding.activityConfirmationCodeInputCode.addOnCompleteListener(new OnCodeCompleteListener() {
            @Override
            public void onCompleted(String code) {
                mCode = code;
//                binding.activityConfirmationCodeInputCode.setCode(code);
            }
        });
    }

    private void startPhoneNumberVerification(final String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(ActivationCodeActivity.this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                HelperMethod.makeTextToast(getApplicationContext(), "on Verification Completed ");
                                signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                HelperMethod.makeTextToast(getApplicationContext(), "can not send code ");
                                binding.activityConfirmationCodeTvNumber.setText(e.getMessage());
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                HelperMethod.makeTextToast(getApplicationContext(), "codE is cent to" + phoneNumber);

                                super.onCodeSent(verificationId, forceResendingToken);
                                mVerificationId = verificationId;

                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);


    }

    private void verifyPhoneNumberWithCode(String verificationId, String code) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            HelperMethod.makeTextToast(getApplicationContext(), "Login Successfully");
                            Intent intent = new Intent(ActivationCodeActivity.this, AddNameActivity.class);
                            startActivity(intent);

                            FirebaseUser user = task.getResult().getUser();
                            addUserToDataBse(user.getUid());
                        } else {

                            HelperMethod.makeTextToast(getApplicationContext(), "can not log");

                        }
                    }
                });
    }

    private void addUserToDataBse(String id) {
        mRef.child(id).setValue("").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                HelperMethod.makeTextToast(getApplicationContext(), "user is add ");

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_confirmation_code_btn_confirm:
                HelperMethod.makeTextToast(getApplicationContext(), "confirm codE clicked");
                verifyPhoneNumberWithCode(mVerificationId, mCode);
                break;
        }
    }
}