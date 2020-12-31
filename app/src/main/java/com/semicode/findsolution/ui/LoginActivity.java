package com.semicode.findsolution.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.activityLoginBtnNext.setOnClickListener(this);
//        binding.activityLoginBtnNext.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_login_btn_next:
                String phoneNumber = binding.activityLoginEtPhoneNumber.getText().toString();
                if (TextUtils.isEmpty(phoneNumber)){
                    binding.activityLoginEtPhoneNumber.setError("enter your phone");
                }else {
                    Intent intent = new Intent(LoginActivity.this, ActivationCodeActivity.class);
                    intent.putExtra("PHONE_NUMBER", phoneNumber);
                    startActivity(intent);
                }


                break;
        }
    }

}