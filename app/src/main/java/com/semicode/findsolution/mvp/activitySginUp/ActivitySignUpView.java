package com.semicode.findsolution.mvp.activitySginUp;

import com.semicode.findsolution.data.model.loginModel.LoginData;
import com.semicode.findsolution.data.model.signUp.Data;

public interface ActivitySignUpView {


    void onConnectionFailed();
    void onSignUpSuccessfully(Data data);
    void onSignUpFailed(String filedMsg);
    void onSignUpFailure(String message);
    void onLoadSignUp();
    void onFinishSignUp();


    void onLoadLogin();
    void onLoginSuccess(LoginData loginData);
    void onLoginFailed(String message);
    void onLoginFinish();
    void onLoginFailure(String message);
}
