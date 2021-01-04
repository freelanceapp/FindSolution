package com.semicode.findsolution.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.SectionFilterAdapter;
import com.semicode.findsolution.databinding.ActivitySectionBinding;
import com.semicode.findsolution.model.SectionModel;

import java.util.ArrayList;
import java.util.List;


public class SectionActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySectionBinding binding;
    private SectionFilterAdapter adapter;
    private List<SectionModel> dataLidt = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySectionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        intilView();

    }

    private void intilView() {
        dataLidt.add(new SectionModel("one", R.drawable.ic_menu_home));
        dataLidt.add(new SectionModel("two", R.drawable.ic_menu_home));

        adapter = new SectionFilterAdapter(this, dataLidt);
        binding.recyclerViewTop.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_login_btn_next:

                break;
        }
    }

}