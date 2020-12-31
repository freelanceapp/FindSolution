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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.ActivityAddNameBinding;


public class AddNameActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityAddNameBinding binding;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference().child("User");
        binding.activityAddNameBtnConfirm.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkUserNameFullOrNot();
    }

    private void upDataUserName(String name) {
        mRef.child(mAuth.getCurrentUser().getUid()).child("Name").setValue(name).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                HelperMethod.makeTextToast(getApplicationContext(), "updated successfully");
                Intent intent = new Intent(AddNameActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    private void checkUserNameFullOrNot() {
        final String currentUserId = mAuth.getCurrentUser().getUid();
        mRef.child(currentUserId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if ((snapshot.child("Name").exists())) {
                    HelperMethod.makeTextToast(getApplicationContext(), "name is full");
                    Intent intent = new Intent(AddNameActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {

                    HelperMethod.makeTextToast(getApplicationContext(), "name is empty enter your name");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_add_name_btn_confirm:
                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                String name = binding.activityAddNameEtName.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    HelperMethod.makeTextToast(getApplicationContext(), "please enter your name ");

                } else {
                    upDataUserName(name);
                }

                break;
        }
    }
}