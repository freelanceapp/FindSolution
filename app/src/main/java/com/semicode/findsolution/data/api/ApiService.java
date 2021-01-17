package com.semicode.findsolution.data.api;

import com.semicode.findsolution.data.model.GeneralResponse;
import com.semicode.findsolution.data.model.Slider.SlidersModel;
import com.semicode.findsolution.data.model.appInformation.AppInformation;
import com.semicode.findsolution.data.model.categories.Category;
import com.semicode.findsolution.data.model.loginModel.Login;
import com.semicode.findsolution.data.model.packageModel.Packages;
import com.semicode.findsolution.data.model.signUp.SignUpModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiService {
    @POST("login")
    Call<Login> login(@Query(value = "phone_code") String phoneCode,
                      @Query(value = "phone") String phone
    );

    @Multipart
    @POST("ClientRegister")
    Call<SignUpModel> signUp(
            @Part MultipartBody.Part logo,
            @Part("phone_code") RequestBody phoneCode,
            @Part("phone") RequestBody phone,
            @Part("name") RequestBody name,
            @Part("software_type") RequestBody softwareType
    );

    @GET("allCategories")
    Call<Category> getCategories();

    @GET("allPackages")
    Call<Packages> getAllPackages();

    @GET("sliders")
    Call<SlidersModel> getSliders();

    @POST("contactUs")
    Call<GeneralResponse> contactUs(@Query(value = "name") String name
            , @Query(value = "email") String email
            , @Query(value = "phone") String phone
            , @Query(value = "subject") String subject
            , @Query(value = "message") String message
    );
    @GET("app/info")
    Call<AppInformation> getAppInformation();
}
