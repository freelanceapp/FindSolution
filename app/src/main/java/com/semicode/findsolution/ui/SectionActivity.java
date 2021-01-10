package com.semicode.findsolution.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.SectionFilterAdapter;
import com.semicode.findsolution.adapter.UserAdapter;
import com.semicode.findsolution.databinding.ActivitySectionBinding;
import com.semicode.findsolution.model.SectionModel;
import com.semicode.findsolution.model.UserModel;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.share.Language;
import com.semicode.findsolution.share.SharedPreferencesManger;
import com.semicode.findsolution.ui.homeActivity.HomeActivity;

import java.util.ArrayList;
import java.util.List;


public class SectionActivity extends AppCompatActivity implements SectionFilterAdapter.OnKindClick, UserAdapter.OnUserClick {
    private ActivitySectionBinding binding;
    private SectionFilterAdapter kindAdapter;
    private UserAdapter userAdapter;
    private List<SectionModel> kindList = new ArrayList<>();
    private List<UserModel> userList = new ArrayList<>();
    private String lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySectionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        intilView();

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        lang = SharedPreferencesManger.LoadData(this, SharedPreferencesManger.LANGUAGE, "ar");
        super.attachBaseContext(Language.updateResources(newBase,lang));
    }

    private void intilView() {
        binding.activitySectonToolbar.setCollapseIcon(getDrawable(R.drawable.ic_edit));
        getKindData();
        getUserData();
        kindAdapter = new SectionFilterAdapter(this, kindList, this);
        userAdapter = new UserAdapter(this, userList, this);
        binding.recyclerViewTop.setAdapter(kindAdapter);
        binding.recyclerViewBottom.setAdapter(userAdapter);
        binding.activitySectonToolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(binding.activitySectonToolbar);
        binding.activitySectonToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

    }

    private void getKindData() {
        kindList.add(new SectionModel("all", R.drawable.ic_name));
        kindList.add(new SectionModel("Engineering", R.drawable.ic_location));
        kindList.add(new SectionModel("Engineerin", R.drawable.ic_jop));
        kindList.add(new SectionModel("two", R.drawable.ic_kind));
    }

    private void getUserData() {
        userList.add(new UserModel("ali", "lowyer", "tanta", "office"));
        userList.add(new UserModel("ali", "lowyer", "tanta", "office"));
        userList.add(new UserModel("ali", "lowyer", "tanta", "office"));
        userList.add(new UserModel("ali", "lowyer", "tanta", "office"));
        userList.add(new UserModel("ali", "lowyer", "tanta", "office"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onItemKindClick(int position) {
        HelperMethod.makeTextToast(this, "" + position);


    }

    @Override
    public void onItemUserClick(int position) {
        startActivity(new Intent(this, UserDetailsActivity.class));

    }
}