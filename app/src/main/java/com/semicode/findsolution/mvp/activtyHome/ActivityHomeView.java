package com.semicode.findsolution.mvp.activtyHome;

import com.semicode.findsolution.data.model.appInformation.AppInformationData;
import com.semicode.findsolution.data.model.categories.CategoryDate;

import java.util.List;

public interface ActivityHomeView {
    void onFinished();
    void onHomeFragmentSelected();

    void onGetAppInformation(AppInformationData appInformationData);

    void onFailedLoadInformationData();
}
