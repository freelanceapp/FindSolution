
package com.semicode.findsolution.data.model.categories;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<CategoryDate> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    private final static long serialVersionUID = -7620521331250877071L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
    }

    /**
     * 
     * @param data
     * @param message
     * @param status
     */
    public Category(List<CategoryDate> data, String message, Integer status) {
        super();
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public List<CategoryDate> getData() {
        return data;
    }

    public void setData(List<CategoryDate> data) {
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
