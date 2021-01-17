package com.semicode.findsolution.ui.homeActivity.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.SectionAdapter;
import com.semicode.findsolution.adapter.SliderAdapter;
import com.semicode.findsolution.data.model.Slider.SliderData;
import com.semicode.findsolution.data.model.categories.CategoryDate;
import com.semicode.findsolution.databinding.FragmentHomeBinding;
import com.semicode.findsolution.data.model.SectionModel;
import com.semicode.findsolution.mvp.fragment_home.HomePresenter;
import com.semicode.findsolution.mvp.fragment_home.HomeView;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.ui.SectionActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements SectionAdapter.ONSectionClick, HomeView {

    FragmentHomeBinding binding;
    SectionAdapter adapter;
    SliderAdapter sliderAdapter;
    HomePresenter presenter;
    private List<CategoryDate> datalist = new ArrayList<>();
    private List<SliderData> sliderData = new ArrayList<>();


    public static HomeFragment newInstance() {

        return new HomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        initView();
//        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    private void initView() {
//        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        adapter = new SectionAdapter(getActivity(), datalist, this);
        sliderAdapter = new SliderAdapter(getActivity(), sliderData);
        presenter = new HomePresenter(getActivity(), this);
        binding.homeFragmentRvSections.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.homeFragmentRvSections.setAdapter(adapter);
    }

//    private void getSectionData() {
//        datalist.add(new SectionModel("one", R.drawable.ic_section_legal));
//        datalist.add(new SectionModel("two", R.drawable.ic_section_engineering));
//        datalist.add(new SectionModel("tree", R.drawable.ic_section_healthy));
//        datalist.add(new SectionModel("four", R.drawable.ic_section_finance));
//        datalist.add(new SectionModel("five", R.drawable.ic_section_administrative));
//        datalist.add(new SectionModel("sex", R.drawable.ic_section_auditors_services));
//    }

    @Override
    public void onSectionClick(int position) {
        HelperMethod.makeTextToast(getActivity(), " clicked   " + position);
        Intent intent = new Intent(getActivity(), SectionActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.top_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater()
//        return true;
//    }
    @Override
    public void onGetAllBasicCategories(List<CategoryDate> data) {
        HelperMethod.makeTextToast(getActivity(), "data load successfully");
        datalist.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFiled() {
        HelperMethod.makeTextToast(getActivity(), "can't load data");

    }

    @Override
    public void onFailure() {
        HelperMethod.makeTextToast(getActivity(), "on failure");

    }

    @Override
    public void onLoadSlider(List<SliderData> data) {
        HelperMethod.makeTextToast(getActivity(), "slider data load successfully");
        sliderData.addAll(data);
        sliderAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailedSlider(String error) {
        HelperMethod.makeTextToast(getActivity(), "failed :" + error);

    }

    @Override
    public void onFailureSlider(String message) {
        HelperMethod.makeTextToast(getActivity(), "Failure :" + message);

    }
}