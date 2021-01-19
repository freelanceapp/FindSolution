package com.semicode.findsolution.mvp.activitySginUp;

import android.content.Context;
import android.net.Uri;

import com.semicode.findsolution.data.api.Api;
import com.semicode.findsolution.data.model.loginModel.Login;
import com.semicode.findsolution.data.model.signUp.SignUpModel;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.tags.Tags;
import com.semicode.findsolution.ui.SignUpActivity;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySignUpPresenter {
    private Context context;
    private ActivitySignUpView view;
    private SignUpActivity activity;

    private String smsCode = "";
    private String lang;

    public ActivitySignUpPresenter(Context context, ActivitySignUpView view) {
        this.context = context;
        this.activity = (SignUpActivity) context;
        this.view = view;

    }

    public void signUp(String imagePath, String phone_code, String phone, String name) {
        view.onLoadSignUp();
        RequestBody name_part = HelperMethod.getRequestBodyText(name);
        RequestBody phone_code_part = HelperMethod.getRequestBodyText(phone_code.replace("+", "00"));
        RequestBody phone_part = HelperMethod.getRequestBodyText(phone);
        RequestBody software_type_part = HelperMethod.getRequestBodyText("android");


        MultipartBody.Part image_form_part = HelperMethod.getMultiPartImage(context, Uri.parse(imagePath), "logo");

        if (HelperMethod.isConnected(context)) {
            Api.getApiService(Tags.base_url).signUp( image_form_part,phone_code_part, phone_part, name_part, software_type_part).enqueue(new Callback<SignUpModel>() {
                @Override
                public void onResponse(Call<SignUpModel> call, Response<SignUpModel> response) {
                    if (response.isSuccessful()) {
//                        view.onSignUpSuccessfully(response.body().getLoginData());
                        view.onSignUpSuccessfully();
                    } else {
                        view.onSignUpFailed(response.message() + "--" + response.code());
                    }
                }

                @Override
                public void onFailure(Call<SignUpModel> call, Throwable t) {
                    view.onSignUpFailure(t.getMessage());
                }
            });
        } else {
            view.onFinishSignUp();
            view.onConnectionFailed();
        }
    }

    public void login(String phone_code, String phone) {
        view.onLoadLogin();
        Api.getApiService(Tags.base_url).login(phone_code, phone).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body().getStatus() == 200) {
                    view.onLoginSuccess(response.body().getUserModelData());
                } else {
                    view.onLoginFailed(response.body().getMessage());
                }
                view.onLoginFinish();

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                view.onLoginFailure(t.getMessage());
                view.onLoginFinish();

            }
        });
    }

}
