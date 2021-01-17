package com.semicode.findsolution.mvp.fragmentConnnectUs;

import android.content.Context;

import androidx.fragment.app.FragmentManager;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.api.Api;
import com.semicode.findsolution.data.model.GeneralResponse;
import com.semicode.findsolution.data.model.packageModel.Packages;
import com.semicode.findsolution.mvp.fragmentSubscription.SubscriptionView;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.tags.Tags;
import com.semicode.findsolution.ui.homeActivity.fragment.ContinueSubscriptionFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.SubscriptionFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectUsPresenter {


    private Context context;
    private ConnectUsView view;


    public ConnectUsPresenter(Context context, ConnectUsView connectUsView) {
        this.context = context;
        this.view = connectUsView;


    }

    public void connectUs(String name, String email, String phone, String subject, String message) {
        if (HelperMethod.isConnected(context)) {
            Api.getApiService(Tags.base_url).contactUs(name, email, phone, subject, message).enqueue(new Callback<GeneralResponse>() {
                @Override
                public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                    if (response.isSuccessful()) {
                        view.onMessageSend();
                    } else {
                        view.onFailedSendMessage(response.body().getMessage());
                    }
                }

                @Override
                public void onFailure(Call<GeneralResponse> call, Throwable t) {
                    view.onFailure(t.getMessage());
                }
            });

        } else {
            view.onInternetFailed();
        }
    }


    public interface ConnectUsView {

        void onMessageSend();

        void onFailedSendMessage(String message);

        void onFailure(String message);

        void onInternetFailed();
    }
}
