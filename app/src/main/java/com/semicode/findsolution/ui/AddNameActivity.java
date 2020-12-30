package com.semicode.findsolution.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.ActivityAddNameBinding;


public class AddNameActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityAddNameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.activityAddNameBtnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_add_name_btn_confirm :
                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}