
package com.semicode.findsolution.data.model.categories;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryDate implements Serializable
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
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("is_shown")
    @Expose
    private String isShown;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("parent_category")
    @Expose
    private Object parentCategory;
    private final static long serialVersionUID = -6458900904997565272L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CategoryDate() {
    }

    /**
     * 
     * @param image
     * @param createdAt
     * @param level
     * @param isShown
     * @param parentCategory
     * @param id
     * @param title
     * @param parentId
     * @param desc
     * @param updatedAt
     */
    public CategoryDate(Integer id, String title, Object desc, String image, Object parentId, String level, String isShown, String createdAt, String updatedAt, Object parentCategory) {
        super();
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.parentId = parentId;
        this.level = level;
        this.isShown = isShown;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.parentCategory = parentCategory;
    }

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

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIsShown() {
        return isShown;
    }

    public void setIsShown(String isShown) {
        this.isShown = isShown;
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

    public Object getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Object parentCategory) {
        this.parentCategory = parentCategory;
    }

}
