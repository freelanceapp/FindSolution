package com.semicode.findsolution.mvp.activitySginUp;

import com.semicode.findsolution.data.model.UserModelData;

public interface ActivitySignUpView {


    void onConnectionFailed();
    void onSignUpSuccessfully(UserModelData userModelData);
    void onSignUpSuccessfully();

    void onSignUpFailed(String filedMsg);
    void onSignUpFailure(String message);
    void onLoadSignUp();
    void onFinishSignUp();


    void onLoadLogin();
    void onLoginSuccess(UserModelData userModelData);
    void onLoginFailed(String message);
    void onLoginFinish();
    void onLoginFailure(String message);

}
