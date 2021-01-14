package com.semicode.findsolution.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.ui.homeActivity.fragment.BaseFragment;


public class BaseActivity extends AppCompatActivity {

    public BaseFragment baseFragment;


    public void superBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }
}
