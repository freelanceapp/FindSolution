package com.semicode.findsolution.ui.homeActivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.semicode.findsolution.R;
import com.semicode.findsolution.databinding.FragmentTermsAndConditionsBinding;


public class TermsAndConditionFragment extends Fragment {

    FragmentTermsAndConditionsBinding binding ;

    public static TermsAndConditionFragment newInstance() {
        TermsAndConditionFragment fragment = new TermsAndConditionFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_terms_and_conditions, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {

    }
}