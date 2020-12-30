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

import com.semicode.findsolution.databinding.ActivitySplashBinding;


public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Transition transition = new TransitionSet();
            transition.setInterpolator(new LinearInterpolator());
            transition.setDuration(500);
            getWindow().setEnterTransition(transition);
            getWindow().setExitTransition(transition);

        }
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 1000);

    }
}