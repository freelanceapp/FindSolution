package com.semicode.findsolution.ui.homeActivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.local.SharedPreferencesManger;
import com.semicode.findsolution.data.model.appInformation.AppInformationData;
import com.semicode.findsolution.databinding.FragmentAboutAppBinding;
import com.semicode.findsolution.databinding.FragmentHomeBinding;


public class AboutAppFragment extends Fragment {

    FragmentAboutAppBinding binding ;
    AppInformationData appInformationData;
    public static AboutAppFragment newInstance() {
        AboutAppFragment fragment = new AboutAppFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about_app, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        appInformationData = SharedPreferencesManger.LoadAppInformationData(getActivity());
        binding.aboutAppTv.setText(appInformationData.getArAboutApp());

    }
}