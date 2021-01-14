
package com.semicode.findsolution.data.model.signUp;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("phone_code")
    @Expose
    private String phoneCode;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("work_title")
    @Expose
    private Object workTitle;
    @SerializedName("more_details")
    @Expose
    private Object moreDetails;
    @SerializedName("contact_number")
    @Expose
    private Object contactNumber;
    @SerializedName("whatsapp_number")
    @Expose
    private Object whatsappNumber;
    @SerializedName("current_package_id")
    @Expose
    private Object currentPackageId;
    @SerializedName("package_started_at")
    @Expose
    private Object packageStartedAt;
    @SerializedName("package_finished_at")
    @Expose
    private Object packageFinishedAt;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("is_confirmed")
    @Expose
    private String isConfirmed;
    @SerializedName("is_block")
    @Expose
    private String isBlock;
    @SerializedName("is_login")
    @Expose
    private String isLogin;
    @SerializedName("logout_time")
    @Expose
    private Object logoutTime;
    @SerializedName("software_type")
    @Expose
    private String softwareType;
    @SerializedName("banner")
    @Expose
    private Object banner;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("sub_category")
    @Expose
    private Object subCategory;
    @SerializedName("number_of_payment_days")
    @Expose
    private Integer numberOfPaymentDays;
    @SerializedName("current_package")
    @Expose
    private Object currentPackage;
    private final static long serialVersionUID = 4411752249661225786L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param currentPackageId
     * @param subCategory
     * @param isBlock
     * @param latitude
     * @param rating
     * @param whatsappNumber
     * @param isLogin
     * @param createdAt
     * @param packageFinishedAt
     * @param contactNumber
     * @param phoneCode
     * @param logo
     * @param isConfirmed
     * @param id
     * @param email
     * @param paymentStatus
     * @param longitude
     * @param updatedAt
     * @param address
     * @param softwareType
     * @param workTitle
     * @param banner
     * @param currentPackage
     * @param token
     * @param logoutTime
     * @param deletedAt
     * @param moreDetails
     * @param phone
     * @param emailVerifiedAt
     * @param packageStartedAt
     * @param numberOfPaymentDays
     * @param name
     * @param userType
     * @param category
     */
    public Data(Integer id, String userType, String name, Object email, String phoneCode, String phone, String logo, Object address, Object latitude, Object longitude, Object workTitle, Object moreDetails, Object contactNumber, Object whatsappNumber, Object currentPackageId, Object packageStartedAt, Object packageFinishedAt, String paymentStatus, String isConfirmed, String isBlock, String isLogin, Object logoutTime, String softwareType, Object banner, Integer rating, Object emailVerifiedAt, Object deletedAt, String createdAt, String updatedAt, String token, Object category, Object subCategory, Integer numberOfPaymentDays, Object currentPackage) {
        super();
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.phoneCode = phoneCode;
        this.phone = phone;
        this.logo = logo;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.workTitle = workTitle;
        this.moreDetails = moreDetails;
        this.contactNumber = contactNumber;
        this.whatsappNumber = whatsappNumber;
        this.currentPackageId = currentPackageId;
        this.packageStartedAt = packageStartedAt;
        this.packageFinishedAt = packageFinishedAt;
        this.paymentStatus = paymentStatus;
        this.isConfirmed = isConfirmed;
        this.isBlock = isBlock;
        this.isLogin = isLogin;
        this.logoutTime = logoutTime;
        this.softwareType = softwareType;
        this.banner = banner;
        this.rating = rating;
        this.emailVerifiedAt = emailVerifiedAt;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.token = token;
        this.category = category;
        this.subCategory = subCategory;
        this.numberOfPaymentDays = numberOfPaymentDays;
        this.currentPackage = currentPackage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(Object workTitle) {
        this.workTitle = workTitle;
    }

    public Object getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(Object moreDetails) {
        this.moreDetails = moreDetails;
    }

    public Object getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Object contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Object getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(Object whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public Object getCurrentPackageId() {
        return currentPackageId;
    }

    public void setCurrentPackageId(Object currentPackageId) {
        this.currentPackageId = currentPackageId;
    }

    public Object getPackageStartedAt() {
        return packageStartedAt;
    }

    public void setPackageStartedAt(Object packageStartedAt) {
        this.packageStartedAt = packageStartedAt;
    }

    public Object getPackageFinishedAt() {
        return packageFinishedAt;
    }

    public void setPackageFinishedAt(Object packageFinishedAt) {
        this.packageFinishedAt = packageFinishedAt;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(String isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public String getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(String isBlock) {
        this.isBlock = isBlock;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public Object getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Object logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getSoftwareType() {
        return softwareType;
    }

    public void setSoftwareType(String softwareType) {
        this.softwareType = softwareType;
    }

    public Object getBanner() {
        return banner;
    }

    public void setBanner(Object banner) {
        this.banner = banner;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public Object getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Object subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getNumberOfPaymentDays() {
        return numberOfPaymentDays;
    }

    public void setNumberOfPaymentDays(Integer numberOfPaymentDays) {
        this.numberOfPaymentDays = numberOfPaymentDays;
    }

    public Object getCurrentPackage() {
        return currentPackage;
    }

    public void setCurrentPackage(Object currentPackage) {
        this.currentPackage = currentPackage;
    }

}
