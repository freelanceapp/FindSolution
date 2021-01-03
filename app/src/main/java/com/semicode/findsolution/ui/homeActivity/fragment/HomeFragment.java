package com.semicode.findsolution.ui.homeActivity.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding ;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {

    }
}