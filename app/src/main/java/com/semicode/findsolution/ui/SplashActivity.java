package com.semicode.findsolution.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.semicode.findsolution.databinding.ActivitySplashBinding;


public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mAuth = FirebaseAuth.getInstance();

        Transition transition = new TransitionSet();
        transition.setInterpolator(new LinearInterpolator());
        transition.setDuration(500);
        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = mAuth.getCurrentUser();

                if (currentUser == null) {

                    Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(mainIntent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, AddNameActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);

    }


}