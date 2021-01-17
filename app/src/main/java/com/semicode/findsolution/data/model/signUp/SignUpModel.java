
package com.semicode.findsolution.data.model.signUp;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpModel implements Serializable
{

    @SerializedName("data")
    @Expose
    private SignUpData data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    private final static long serialVersionUID = 3032761860840826279L;

    public SignUpData getData() {
        return data;
    }

    public void setData(SignUpData signUpData) {
        this.data = signUpData;
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
