package com.semicode.findsolution.ui.homeActivity.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.SectionAdapter;
import com.semicode.findsolution.databinding.FragmentHomeBinding;
import com.semicode.findsolution.model.SectionModel;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.ui.SectionActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements SectionAdapter.ONSectionClick {

    FragmentHomeBinding binding;
    SectionAdapter adapter;
    private List<SectionModel> datalist = new ArrayList<>();


    public static HomeFragment newInstance() {

        return new HomeFragment();
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

        getSectionData();
        adapter = new SectionAdapter(getActivity(), datalist, this);

        binding.homeFragmentRvSections.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.homeFragmentRvSections.setAdapter(adapter);
    }

    private void getSectionData() {
        datalist.add(new SectionModel("one", R.drawable.ic_section_legal));
        datalist.add(new SectionModel("two", R.drawable.ic_section_engineering));
        datalist.add(new SectionModel("tree", R.drawable.ic_section_healthy));
        datalist.add(new SectionModel("four", R.drawable.ic_section_finance));
        datalist.add(new SectionModel("five", R.drawable.ic_section_administrative));
        datalist.add(new SectionModel("sex", R.drawable.ic_section_auditors_services));
    }

    @Override
    public void onSectionClick(int position) {
        HelperMethod.makeTextToast(getActivity(), " clicked   " + position);
        Intent intent = new Intent(getActivity(), SectionActivity.class);
        getActivity().startActivity(intent);
    }
}