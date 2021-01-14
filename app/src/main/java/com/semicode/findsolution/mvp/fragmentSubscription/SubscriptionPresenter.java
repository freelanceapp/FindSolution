package com.semicode.findsolution.mvp.fragmentSubscription;

import android.content.Context;

import androidx.fragment.app.FragmentManager;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.api.Api;
import com.semicode.findsolution.data.model.categories.Category;
import com.semicode.findsolution.data.model.packageModel.Packages;
import com.semicode.findsolution.mvp.fragment_home.HomeView;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.tags.Tags;
import com.semicode.findsolution.ui.homeActivity.fragment.ContinueSubscriptionFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.SubscriptionFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubscriptionPresenter {


    private Context context;
    private SubscriptionView view;
    private FragmentManager fragmentManager;

    private SubscriptionFragment subscriptionFragment;
    private ContinueSubscriptionFragment continueSubscriptionFragment;


    public SubscriptionPresenter(Context context, SubscriptionView subscriptionView, FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.view = subscriptionView;

        getAllPackages();
    }

    private void getAllPackages() {
        if (HelperMethod.isConnected(context)) {
            Api.getApiService(Tags.base_url).getAllPackages().enqueue(new Callback<Packages>() {
                @Override
                public void onResponse(Call<Packages> call, Response<Packages> response) {
                    if (response.body().getStatus() == 200 && (!response.body().getData().isEmpty())) {
                        view.onGetAllPackages(response.body().getData());
                    }
                }

                @Override
                public void onFailure(Call<Packages> call, Throwable t) {
                    view.onFailure(t.getMessage());

                }
            });

        } else {
            view.onInternetFailed();
        }
    }

    public void displayFragmentSubscription() {
        if (subscriptionFragment == null) {
            subscriptionFragment = SubscriptionFragment.newInstance();
        }

        if (continueSubscriptionFragment != null && continueSubscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(continueSubscriptionFragment).commit();
        }

        if (subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().show(subscriptionFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, subscriptionFragment, "Subscription").commit();
        }
    }

    public void displayFragmentContinueSub() {
        if (continueSubscriptionFragment == null) {
            continueSubscriptionFragment = ContinueSubscriptionFragment.newInstance();
        }

        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }

        if (continueSubscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().show(continueSubscriptionFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, continueSubscriptionFragment, "Continue Subscription").commit();
        }
    }
}
