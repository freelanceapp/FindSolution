package com.semicode.findsolution.ui.homeActivity.fragment;

import androidx.fragment.app.Fragment;

import com.semicode.findsolution.ui.homeActivity.HomeActivity;

public class BaseFragment extends Fragment {

    public HomeActivity homeActivity;

    public void initFragment() {
        homeActivity = (HomeActivity) getActivity();
        homeActivity.baseFragment = this;


    }

    public void onBack() {

    }

}
