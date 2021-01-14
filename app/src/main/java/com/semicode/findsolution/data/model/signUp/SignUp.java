
package com.semicode.findsolution.data.model.signUp;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUp implements Serializable
{

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    private final static long serialVersionUID = -435786610676453678L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SignUp() {
    }

    /**
     * 
     * @param data
     * @param message
     * @param status
     */
    public SignUp(Data data, String message, Integer status) {
        super();
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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
