
package com.semicode.findsolution.data.model.sliderModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SliderData implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private Object desc;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("action_link")
    @Expose
    private Object actionLink;
    @SerializedName("action_link_title")
    @Expose
    private Object actionLinkTitle;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    private final static long serialVersionUID = -8881827597367072162L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDesc() {
        return desc;
    }

    public void setDesc(Object desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getActionLink() {
        return actionLink;
    }

    public void setActionLink(Object actionLink) {
        this.actionLink = actionLink;
    }

    public Object getActionLinkTitle() {
        return actionLinkTitle;
    }

    public void setActionLinkTitle(Object actionLinkTitle) {
        this.actionLinkTitle = actionLinkTitle;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
