package com.semicode.findsolution.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.data.model.UserModelData;
import com.semicode.findsolution.databinding.ActivityProfileBinding;
import com.semicode.findsolution.share.Language;
import com.semicode.findsolution.data.local.SharedPreferencesManger;


public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    String lang ;
    private UserModelData userModelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.profileIvMenu.setOnClickListener(v -> onBackPressed());
        binding.profileIvEdit.setOnClickListener(v -> openEditActivity());
        intilView();

    }

    private void openEditActivity() {
        Intent intent = new Intent(this,EditProfileActivity.class);
        startActivity(intent);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        lang = SharedPreferencesManger.LoadData(this, SharedPreferencesManger.LANGUAGE, "ar");
        super.attachBaseContext(Language.updateResources(newBase,lang));
    }

    private void intilView() {
        userModelData = SharedPreferencesManger.LoadUserData(this);
        binding.setUserData(userModelData);
//        binding.userDetailsTvName.setText(userModelData.getName());
//        binding.userDetailsTvJopDetails.setText( userModelData.getPhoneCode()+""+userModelData.getPhone());
    }


}