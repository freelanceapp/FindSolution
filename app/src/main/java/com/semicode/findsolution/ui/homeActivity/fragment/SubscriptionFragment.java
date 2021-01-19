package com.semicode.findsolution.ui.homeActivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;

import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.PackageAdapter;
import com.semicode.findsolution.data.model.packageModel.PackageData;
import com.semicode.findsolution.databinding.FragmentSubscriptionBinding;
import com.semicode.findsolution.mvp.fragmentSubscription.SubscriptionPresenter;
import com.semicode.findsolution.mvp.fragmentSubscription.SubscriptionView;
import com.semicode.findsolution.share.HelperMethod;

import java.util.ArrayList;
import java.util.List;


public class SubscriptionFragment extends Fragment implements SubscriptionView, PackageAdapter.OnPackageClick {

    FragmentSubscriptionBinding binding;
    SubscriptionPresenter presenter;
    PackageAdapter adapter;
    List<PackageData> dataList = new ArrayList<>();
    FragmentManager fragmentManager;

    public static SubscriptionFragment newInstance() {
        SubscriptionFragment fragment = new SubscriptionFragment();

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
        fragmentManager = getActivity().getSupportFragmentManager();
        presenter = new SubscriptionPresenter(getActivity(), this, fragmentManager);
        adapter = new PackageAdapter( dataList, getActivity(),this::onPackageClick);
        binding.subRvPackage.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.subRvPackage.setAdapter(adapter);
        getActivity().getActionBar();
    }

    @Override
    public void onGetAllPackages(List<PackageData> data) {
        dataList.addAll(data);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFailure(String message) {
        HelperMethod.makeTextToast(getActivity(), "" + message);
    }

    @Override
    public void onInternetFailed() {
        HelperMethod.makeTextToast(getActivity(), "please check your Internet Connection");
    }

    @Override
    public void onPackageClick(int position) {
        HelperMethod.makeTextToast(getActivity(), "you click " + position + "    package");
        binding.subscriptionLayout.setVisibility(View.GONE);
        binding.subscriptionLayoutContinue.setVisibility(View.VISIBLE);
//        presenter.displayFragmentContinueSub();
    }
}