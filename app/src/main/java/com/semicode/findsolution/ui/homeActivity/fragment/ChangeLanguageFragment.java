package com.semicode.findsolution.ui.homeActivity.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.semicode.findsolution.R;

import com.semicode.findsolution.databinding.FragmentChangeLanguageBinding;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.share.SharedPreferencesManger;
import com.semicode.findsolution.ui.ProfileActivity;
import com.semicode.findsolution.ui.homeActivity.HomeActivity;


public class ChangeLanguageFragment extends Fragment implements View.OnClickListener {

    FragmentChangeLanguageBinding binding;
    HomeActivity activity;
    String lang;

    public static ChangeLanguageFragment newInstance() {
        ChangeLanguageFragment fragment = new ChangeLanguageFragment();

        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_language, container, false);
        initView();


        return binding.getRoot();
    }

    private void setSelectedButton(View view) {
        switch (view.getId()) {
            case R.id.tv_arabic:
                binding.tvArabic.setBackgroundResource(R.color.white);
                binding.tvEnglish.setBackgroundResource(R.color.gray);

                break;
            case R.id.tv_english:
                binding.tvEnglish.setBackgroundResource(R.color.white);
                binding.tvArabic.setBackgroundResource(R.color.gray);
                break;
        }
    }

    private void initView() {
        activity = (HomeActivity) getActivity();
        lang = SharedPreferencesManger.LoadData(getActivity(), SharedPreferencesManger.LANGUAGE,"ar");
        binding.tvArabic.setOnClickListener(this);
        binding.tvEnglish.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        setSelectedButton(v);
        switch (v.getId()) {
            case R.id.tv_arabic:
//                SharedPreferencesManger.SaveData(getActivity(), SharedPreferencesManger.LANGUAGE, "ar");
                activity.refreshActivity("ar");


                break;
            case R.id.tv_english:
                SharedPreferencesManger.SaveData(getActivity(), SharedPreferencesManger.LANGUAGE, "en");
                activity.refreshActivity("en");

                break;
        }
    }
}