package com.semicode.findsolution.mvp.activitySginUp;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.semicode.findsolution.R;
import com.semicode.findsolution.data.api.Api;
import com.semicode.findsolution.data.model.loginModel.Login;
import com.semicode.findsolution.data.model.signUp.SignUp;
import com.semicode.findsolution.mvp.activtyConfirmationCode.ActivityConfirmationCodeView;
import com.semicode.findsolution.share.Common;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.tags.Tags;
import com.semicode.findsolution.ui.ConfirmationCodeActivity;
import com.semicode.findsolution.ui.SignUpActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
        RequestBody name_part = Common.getRequestBodyText(name);
        RequestBody phone_code_part = Common.getRequestBodyText(phone_code.replace("+", "00"));
        RequestBody phone_part = Common.getRequestBodyText(phone);
        RequestBody software_type_part = Common.getRequestBodyText("android");


        MultipartBody.Part image_form_part = Common.getMultiPartImage(context, Uri.parse(imagePath), "logo");

        if (HelperMethod.isConnected(context)) {
            Api.getApiService(Tags.base_url).signUp(image_form_part, phone_code_part, phone_part, name_part, software_type_part).enqueue(new Callback<SignUp>() {
                @Override
                public void onResponse(Call<SignUp> call, Response<SignUp> response) {


                    if (response.body() != null && response.body().getStatus() == 200) {
                        view.onSignUpSuccessfully(response.body().getData());
                    } else {
                        view.onSignUpFailed(response.body().getMessage());
                    }
                    view.onFinishSignUp();
                }

                @Override
                public void onFailure(Call<SignUp> call, Throwable t) {
                    view.onSignUpFailure(t.getMessage());
                    view.onFinishSignUp();
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
                    view.onLoginSuccess(response.body().getLoginData());
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
