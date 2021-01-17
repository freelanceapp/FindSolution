
package com.semicode.findsolution.data.model.appInformation;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppInformation implements Serializable
{

    @SerializedName("data")
    @Expose
    private AppInformationData appInformationData;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    private final static long serialVersionUID = 1855096284362676590L;

    public AppInformationData getData() {
        return appInformationData;
    }

    public void setData(AppInformationData data) {
        this.appInformationData = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
