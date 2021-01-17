
package com.semicode.findsolution.data.model.Slider;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SlidersModel implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<SliderData> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    private final static long serialVersionUID = -3553534557821681461L;

    public List<SliderData> getData() {
        return data;
    }

    public void setData(List<SliderData> data) {
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
