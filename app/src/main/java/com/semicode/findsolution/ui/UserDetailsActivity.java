package com.semicode.findsolution.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.databinding.ActivityUserDetailsBinding;
import com.semicode.findsolution.share.Language;
import com.semicode.findsolution.share.SharedPreferencesManger;


public class UserDetailsActivity extends AppCompatActivity {
    private ActivityUserDetailsBinding binding;
    private String lang;

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

    @Override
    protected void attachBaseContext(Context newBase) {
        lang = SharedPreferencesManger.LoadData(this, SharedPreferencesManger.LANGUAGE, "ar");
        super.attachBaseContext(Language.updateResources(newBase, lang));
    }


}