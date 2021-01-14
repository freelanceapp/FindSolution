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

        return binding.getRoot();
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private void setSelectedButton(String language) {
        if (language.equals("en")) {
            binding.changeLangTv.setCompoundDrawablesRelativeWithIntrinsicBounds(getActivity().getDrawable(R.drawable.ic_saudi_arabia), null, null, null);
        } else if (language.equals("ar")) {
            binding.changeLangTv.setCompoundDrawablesRelativeWithIntrinsicBounds(getActivity().getDrawable(R.drawable.ic_english), null, null, null);

        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initView() {

        activity = (HomeActivity) getActivity();
        lang = SharedPreferencesManger.LoadData(getActivity(), SharedPreferencesManger.LANGUAGE, "ar");
        setSelectedButton(lang);
        binding.changeLangTv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_lang_tv:
                if (lang.equals("ar")) {
                    setSelectedButton("en");
                    SharedPreferencesManger.SaveData(getActivity(), SharedPreferencesManger.LANGUAGE, "en");
                    activity.refreshActivity("en");
                } else {
                    setSelectedButton("ar");
                    SharedPreferencesManger.SaveData(getActivity(), SharedPreferencesManger.LANGUAGE, "ar");
                    activity.refreshActivity("ar");
                }


                break;
        }
    }
}