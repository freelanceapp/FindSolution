package com.semicode.findsolution.mvp.fragment_home;

import com.semicode.findsolution.data.model.categories.CategoryDate;

import java.util.List;

public interface HomeView {

    void onGetAllBasicCategories(List<CategoryDate> data);

    void onFiled();

    void onFailure();
}
