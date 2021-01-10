package com.semicode.findsolution.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.ActivityAddNameBinding;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.share.SharedPreferencesManger;
import com.semicode.findsolution.ui.homeActivity.HomeActivity;


public class AddNameActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityAddNameBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferencesManger.setSharedPreferences(this);
        SharedPreferencesManger.SaveData(this,SharedPreferencesManger.LANGUAGE,"ar");
        binding.activityAddNameBtnConfirm.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_add_name_btn_confirm:
                String name = "mo";
//                binding.activityAddNameEtName.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    HelperMethod.makeTextToast(getApplicationContext(), "please enter your name ");

                } else {
                    Intent intent = new Intent(AddNameActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }

                break;
        }
    }
}