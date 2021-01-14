package com.semicode.findsolution.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.databinding.ActivitySplashBinding;
import com.semicode.findsolution.share.SharedPreferencesManger;


public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferencesManger.setSharedPreferences(this);
        isLogin = SharedPreferencesManger.LoadBoolean(this, SharedPreferencesManger.ISLOGIN);
        Transition transition = new TransitionSet();
        transition.setInterpolator(new LinearInterpolator());
        transition.setDuration(500);
        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (isLogin) {
                    Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        }, 1000);

    }


}