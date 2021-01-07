package com.semicode.findsolution.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.databinding.ActivityUserDetailsBinding;


public class UserDetailsActivity extends AppCompatActivity {
    private ActivityUserDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.userDetailsIvBack.setOnClickListener(v -> onBackPressed());
        intilView();

    }

    private void intilView() {


    }


}