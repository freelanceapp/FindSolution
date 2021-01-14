package com.semicode.findsolution.mvp.fragment_home;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.FragmentManager;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.api.Api;
import com.semicode.findsolution.data.model.categories.Category;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomeView;
import com.semicode.findsolution.tags.Tags;
import com.semicode.findsolution.ui.ProfileActivity;
import com.semicode.findsolution.ui.homeActivity.fragment.AboutAppFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.ChangeLanguageFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.ConnectUsFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.HomeFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.SubscriptionFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.TermsAndConditionFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {


    private Context context;
    private HomeView view;



    public HomePresenter(Context context, HomeView view) {
        this.context = context;
        this.view = view;

        getAllCategories();
    }

    private void getAllCategories() {
        Api.getApiService(Tags.base_url).getCategories().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.body().getStatus() == 200) {
                    view.onGetAllBasicCategories(response.body().getData());
                } else {
                    view.onFiled();
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                view.onFailure();
            }
        });
    }







}
