package com.semicode.findsolution.mvp.fragment_home;

import android.content.Context;

import com.semicode.findsolution.data.api.Api;
import com.semicode.findsolution.data.model.sliderModel.SlidersModel;
import com.semicode.findsolution.data.model.categories.Category;
import com.semicode.findsolution.tags.Tags;

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
        getSlider();
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

    private void getSlider() {
        Api.getApiService(Tags.base_url).getSliders().enqueue(new Callback<SlidersModel>() {
            @Override
            public void onResponse(Call<SlidersModel> call, Response<SlidersModel> response) {
                if (response.isSuccessful()) {
                    view.onLoadSlider(response.body().getData());
                } else {
                    view.onFailedSlider(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<SlidersModel> call, Throwable t) {
                view.onFailureSlider(t.getMessage());
            }
        });
    }


}
