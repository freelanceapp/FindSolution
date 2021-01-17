package com.semicode.findsolution.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.ActivityConfirmationCodeBinding;
import com.semicode.findsolution.mvp.activtyConfirmationCode.ActivityConfirmationCodePresenter;
import com.semicode.findsolution.mvp.activtyConfirmationCode.ActivityConfirmationCodeView;
import com.semicode.findsolution.data.local.SharedPreferencesManger;
import com.semicode.findsolution.share.HelperMethod;

import java.util.Locale;

public class ConfirmationCodeActivity extends AppCompatActivity implements ActivityConfirmationCodeView {
    private ActivityConfirmationCodeBinding binding;

    private String phone_code = "+20";
    private String phoneNumber = "";

    private boolean canSend = false;
    private ActivityConfirmationCodePresenter presenter;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmationCodeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getDataFromIntent();
        intiView();


    }


    private void intiView() {
        String mPhone = phone_code + phoneNumber;
        binding.activityConfirmationCodeTvNumber.setText(mPhone);

        presenter = new ActivityConfirmationCodePresenter(this, this, phone_code, phoneNumber);


        binding.activityConfirmationCodeBtnConfirm.setOnClickListener(v -> {
            String mCode = binding.activityConfirmationCodePinView.getText().toString().trim();
            if (!mCode.isEmpty()) {
                presenter.checkValidCode(mCode);
            } else {
                binding.activityConfirmationCodePinView.setError(getString(R.string.invalid_code));
            }
        });
        binding.activityConfirmationCodeBtnResend.setOnClickListener(view -> {
            if (canSend) {
                canSend = false;
                presenter.resendCode();
            }
        });
    }


    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            phoneNumber = intent.getStringExtra("PHONE_NUMBER");

        }
    }



    @Override
    public void onCounterStarted(String time) {
        binding.activityConfirmationCodeTvResend.setText(String.format(Locale.ENGLISH, "%s %s","", time));
        binding.activityConfirmationCodeTvResend.setBackgroundResource(R.color.transparent);
    }

    @Override
    public void onCounterFinished() {
        binding.activityConfirmationCodeBtnResend.setTextColor(ContextCompat.getColor(ConfirmationCodeActivity.this, R.color.colorAccent));
        binding.activityConfirmationCodeBtnResend.setClickable(true);
        canSend = true;

    }

    @Override
    public void onCodeFailed(String msg) {
        HelperMethod.CreateDialogAlert(this, msg);

    }

    @Override
    public void onLogin() {
//        HelperMethod.makeTextToast(getApplicationContext(), "done Login");
        SharedPreferencesManger.SaveData(this,SharedPreferencesManger.ISLOGIN,true);
        Intent intent = new Intent(ConfirmationCodeActivity.this, SignUpActivity.class);
        intent.putExtra("PHONE_CODE", phone_code);
        intent.putExtra("PHONE_NUMBER", phoneNumber);
        startActivity(intent);
    }

}