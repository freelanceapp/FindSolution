package com.semicode.findsolution.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.databinding.ActivitySplashBinding;
import com.semicode.findsolution.data.local.SharedPreferencesManger;
import com.semicode.findsolution.ui.homeActivity.HomeActivity;


public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    private String userToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferencesManger.setSharedPreferences(this);
        userToken = SharedPreferencesManger.LoadUserData(this).getToken();
        Transition transition = new TransitionSet();
        transition.setInterpolator(new LinearInterpolator());
        transition.setDuration(500);
        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (TextUtils.isEmpty(userToken)) {
                    Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(mainIntent);
                    finish();


                } else {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);

    }


}