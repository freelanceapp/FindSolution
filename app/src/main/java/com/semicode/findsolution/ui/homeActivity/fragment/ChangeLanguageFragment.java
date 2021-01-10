package com.semicode.findsolution.ui.homeActivity.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import java.util.Objects;


public class ChangeLanguageFragment extends Fragment implements View.OnClickListener {

    FragmentChangeLanguageBinding binding;
    HomeActivity activity;
    Drawable img;
    String lang;

    public static ChangeLanguageFragment newInstance() {
        ChangeLanguageFragment fragment = new ChangeLanguageFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_language, container, false);
        initView();
        lang = SharedPreferencesManger.LoadData(getActivity(), SharedPreferencesManger.LANGUAGE, "");
        setSelectedButton(lang);

        return binding.getRoot();
    }


    private void setSelectedButton(String language) {
        if (language == "ar") {
            binding.tvArabic.setCompoundDrawablesRelative(img, null, null, null);
            binding.tvEnglish.setCompoundDrawablesRelative(null, null, null, null);
        } else if (language == "en") {
            binding.tvEnglish.setCompoundDrawablesRelative(null, null, null, null);

            binding.tvArabic.setCompoundDrawablesRelative(img, null, null, null);

        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initView() {
        img = requireActivity().getDrawable(R.drawable.ic_back);
        img.setBounds(0, 0, 60, 60);
        activity = (HomeActivity) getActivity();
        lang = SharedPreferencesManger.LoadData(getActivity(), SharedPreferencesManger.LANGUAGE, "ar");
        binding.tvArabic.setOnClickListener(this);
        binding.tvEnglish.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_arabic:
                setSelectedButton("ar");
                SharedPreferencesManger.SaveData(getActivity(), SharedPreferencesManger.LANGUAGE, "ar");
                activity.refreshActivity("ar");


                break;
            case R.id.tv_english:
                setSelectedButton("en");
                SharedPreferencesManger.SaveData(getActivity(), SharedPreferencesManger.LANGUAGE, "en");
                activity.refreshActivity("en");

                break;
        }
    }
}