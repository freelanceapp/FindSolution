package com.semicode.findsolution.mvp.fragment_home;

import com.semicode.findsolution.data.model.Slider.SliderData;
import com.semicode.findsolution.data.model.categories.CategoryDate;

import java.util.List;

import okhttp3.ResponseBody;

public interface HomeView {

    void onGetAllBasicCategories(List<CategoryDate> data);

    void onFiled();

    void onFailure();

    void onLoadSlider(List<SliderData> data);

    void onFailedSlider(String error);

    void onFailureSlider(String message);
}
