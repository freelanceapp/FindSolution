package com.semicode.findsolution.ui.homeActivity.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.local.SharedPreferencesManger;
import com.semicode.findsolution.data.model.appInformation.AppInformationData;

import com.semicode.findsolution.databinding.FragmentConnectUsBinding;
import com.semicode.findsolution.mvp.fragmentConnnectUs.ConnectUsPresenter;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.ui.homeActivity.HomeActivity;

import java.util.Objects;


public class ConnectUsFragment extends Fragment implements ConnectUsPresenter.ConnectUsView, View.OnClickListener {

    FragmentConnectUsBinding binding;
    ConnectUsPresenter presenter;
    AppInformationData appInformationData;
    HomeActivity activity;

    public static ConnectUsFragment newInstance() {
        ConnectUsFragment fragment = new ConnectUsFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_connect_us, container, false);
        initView();
        binding.connectUsBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.connect_top_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void sendMessage() {
        String name = binding.connectUsEtName.getText().toString();
        String email = binding.connectUsEtEmail.getText().toString();
        String phone = binding.connectUsEtName.getText().toString();
        String subject = binding.connectUsEtSubject.getText().toString();
        String message = binding.connectUsEtMessage.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(name) || TextUtils.isEmpty(name) || TextUtils.isEmpty(name) || TextUtils.isEmpty(name)) {
            HelperMethod.makeTextToast(getActivity(), "please fill all fields correctly");
        } else {
            presenter.connectUs(name, email, phone, subject, message);

        }

    }

    private void initView() {
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        presenter = new ConnectUsPresenter(getActivity(), this);
        appInformationData = SharedPreferencesManger.LoadAppInformationData(getActivity());
        binding.connectUsEtName.setTextInputLayoutFocusedRectEnabled(true);
        binding.connectUsIvFacebook.setOnClickListener(this);
        binding.connectUsIvGoogle.setOnClickListener(this);
        binding.connectUsIvInstagram.setOnClickListener(this);
        binding.connectUsIvTwitter.setOnClickListener(this);
    }

    @Override
    public void onMessageSend() {
        HelperMethod.makeTextToast(getActivity(), "Thank you for you connection");
    }

    @Override
    public void onFailedSendMessage(String message) {
        HelperMethod.makeTextToast(getActivity(), "" + message);
    }

    @Override
    public void onFailure(String message) {
        HelperMethod.makeTextToast(getActivity(), "" + message);

    }

    @Override
    public void onInternetFailed() {
        HelperMethod.makeTextToast(getActivity(), "please check your internet connection ");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connect_us_iv_facebook:
                HelperMethod.openLink(requireActivity(), appInformationData.getFacebook());
                break;
            case R.id.connect_us_iv_google:
                HelperMethod.openLink(requireActivity(), appInformationData.getGooglePlus());

                break;
            case R.id.connect_us_iv_instagram:
                HelperMethod.openLink(requireActivity(), appInformationData.getInstagram());

                break;
            case R.id.connect_us_iv_twitter:
                HelperMethod.openLink(requireActivity(), appInformationData.getTwitter());

                break;
        }
    }
}