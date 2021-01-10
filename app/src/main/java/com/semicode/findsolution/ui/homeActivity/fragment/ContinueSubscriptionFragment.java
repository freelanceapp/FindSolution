package com.semicode.findsolution.ui.homeActivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.FragmentSubscriptionBinding;
import com.semicode.findsolution.databinding.FragmentSubscriptionContinueBindingImpl;


public class ContinueSubscriptionFragment extends Fragment {

    FragmentSubscriptionContinueBindingImpl binding ;

    public static ContinueSubscriptionFragment newInstance() {
        ContinueSubscriptionFragment fragment = new ContinueSubscriptionFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_subscription, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {

    }
}