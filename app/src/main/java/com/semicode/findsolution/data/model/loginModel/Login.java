
package com.semicode.findsolution.data.model.loginModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.semicode.findsolution.data.model.UserModelData;

public class Login implements Serializable
{

    @SerializedName("data")
    @Expose
    private UserModelData userModelData;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    private final static long serialVersionUID = 7841208071722731877L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Login() {
    }

    /**
     * 
     * @param userModelData
     * @param message
     * @param status
     */
    public Login(UserModelData userModelData, String message, Integer status) {
        super();
        this.userModelData = userModelData;
        this.message = message;
        this.status = status;
    }

    public UserModelData getUserModelData() {
        return userModelData;
    }

    public void setUserModelData(UserModelData userModelData) {
        this.userModelData = userModelData;
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
