package com.semicode.findsolution.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.semicode.findsolution.R;
import com.semicode.findsolution.data.local.SharedPreferencesManger;
import com.semicode.findsolution.databinding.ActivityEditProfileBinding;
import com.semicode.findsolution.share.Language;

import java.util.ArrayList;


public class EditProfileActivity extends AppCompatActivity {
    private ActivityEditProfileBinding binding;
    String lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        intilView();

    }

    @Override
    protected void attachBaseContext(Context newBase) {
//        lang = SharedPreferencesManger.LoadData(this, SharedPreferencesManger.LANGUAGE, "ar");
        super.attachBaseContext(Language.updateResources(newBase, "ar"));
    }

    private void intilView() {
        binding.editActivityToolbar.setNavigationIcon(R.drawable.ic_back);
        ArrayList<String> items = new ArrayList<>();
        items.add("Material");
        items.add("Design");
        items.add("Components");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item, items);
        ((MaterialAutoCompleteTextView) binding.textInputLayout3.getEditText()).setAdapter(adapter);

        binding.editActivityToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

    }


}