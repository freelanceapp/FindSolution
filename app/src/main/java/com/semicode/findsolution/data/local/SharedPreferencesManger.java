package com.semicode.findsolution.data.local;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.semicode.findsolution.data.model.UserModelData;
import com.semicode.findsolution.data.model.appInformation.AppInformationData;


public class SharedPreferencesManger {

    public static SharedPreferences sharedPreferences = null;
    //    public static String API_TOKEN;
    public final static String ISLOGIN = "isLogin", USERTOKEN = "userToken", LANGUAGE = "language", APPDATA = "appInformationData", USERDATA = "userData";

    public static void setSharedPreferences(Activity activity) {
        if (sharedPreferences == null) {
            sharedPreferences = activity.getSharedPreferences(
                    "FindSolution", activity.MODE_PRIVATE);
        }
    }

    public static void SaveData(Activity activity, String data_Key, String data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

    public static void SaveData(Activity activity, String data_Key, boolean data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

    public static void SaveData(Activity activity, String data_Key, Object data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String StringData = gson.toJson(data_Value);
            editor.putString(data_Key, StringData);
            editor.commit();
        }
    }

    public static String LoadData(Activity activity, String data_Key, String defValue) {
        setSharedPreferences(activity);

        return sharedPreferences.getString(data_Key, "");
    }

    public static AppInformationData LoadAppInformationData(Activity activity) {
        setSharedPreferences(activity);
        String informationString = sharedPreferences.getString(APPDATA, "");
        Gson gson = new Gson();

        return gson.fromJson(informationString, AppInformationData.class);
    }

    public static UserModelData LoadUserData(Activity activity) {
        setSharedPreferences(activity);
        String userData = sharedPreferences.getString(USERDATA, "");
        Gson gson = new Gson();

        return gson.fromJson(userData, UserModelData.class);
    }

    public static boolean LoadBoolean(Activity activity, String data_Key) {
        setSharedPreferences(activity);

        return sharedPreferences.getBoolean(data_Key, false);
    }

    public static void clean(Activity activity) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
        }
    }

}
