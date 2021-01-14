package com.semicode.findsolution.mvp.fragmentSubscription;

import com.semicode.findsolution.data.model.categories.CategoryDate;
import com.semicode.findsolution.data.model.packageModel.PackageData;

import java.util.List;

public interface SubscriptionView {

    void onGetAllPackages(List<PackageData> data);


    void onFailure(String message);

    void onInternetFailed();
}
