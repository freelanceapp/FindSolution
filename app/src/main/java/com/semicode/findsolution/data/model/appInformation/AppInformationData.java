
package com.semicode.findsolution.data.model.appInformation;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppInformationData implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("terms_condition_link")
    @Expose
    private Object termsConditionLink;
    @SerializedName("about_us_link")
    @Expose
    private Object aboutUsLink;
    @SerializedName("privacy_policy_link")
    @Expose
    private Object privacyPolicyLink;
    @SerializedName("header_logo")
    @Expose
    private String headerLogo;
    @SerializedName("footer_logo")
    @Expose
    private String footerLogo;
    @SerializedName("login_banner")
    @Expose
    private Object loginBanner;
    @SerializedName("image_slider")
    @Expose
    private Object imageSlider;
    @SerializedName("ar_title")
    @Expose
    private String arTitle;
    @SerializedName("en_title")
    @Expose
    private String enTitle;
    @SerializedName("ar_desc")
    @Expose
    private Object arDesc;
    @SerializedName("en_desc")
    @Expose
    private Object enDesc;
    @SerializedName("ar_footer_desc")
    @Expose
    private Object arFooterDesc;
    @SerializedName("en_footer_desc")
    @Expose
    private Object enFooterDesc;
    @SerializedName("company_profile_pdf")
    @Expose
    private Object companyProfilePdf;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("phone1")
    @Expose
    private String phone1;
    @SerializedName("phone2")
    @Expose
    private String phone2;
    @SerializedName("fax")
    @Expose
    private Object fax;
    @SerializedName("android_app")
    @Expose
    private String androidApp;
    @SerializedName("ios_app")
    @Expose
    private String iosApp;
    @SerializedName("email1")
    @Expose
    private String email1;
    @SerializedName("email2")
    @Expose
    private String email2;
    @SerializedName("link")
    @Expose
    private Object link;
    @SerializedName("sms_user_name")
    @Expose
    private Object smsUserName;
    @SerializedName("sms_user_pass")
    @Expose
    private Object smsUserPass;
    @SerializedName("sms_sender")
    @Expose
    private Object smsSender;
    @SerializedName("publisher")
    @Expose
    private Object publisher;
    @SerializedName("default_language")
    @Expose
    private String defaultLanguage;
    @SerializedName("default_theme")
    @Expose
    private Object defaultTheme;
    @SerializedName("offer_muted")
    @Expose
    private Object offerMuted;
    @SerializedName("offer_notification")
    @Expose
    private Integer offerNotification;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("instagram")
    @Expose
    private String instagram;
    @SerializedName("linkedin")
    @Expose
    private String linkedin;
    @SerializedName("telegram")
    @Expose
    private String telegram;
    @SerializedName("youtube")
    @Expose
    private String youtube;
    @SerializedName("google_plus")
    @Expose
    private String googlePlus;
    @SerializedName("snapchat_ghost")
    @Expose
    private String snapchatGhost;
    @SerializedName("whatsapp")
    @Expose
    private String whatsapp;
    @SerializedName("ar_about_app")
    @Expose
    private String arAboutApp;
    @SerializedName("en_about_app")
    @Expose
    private Object enAboutApp;
    @SerializedName("ar_terms_condition")
    @Expose
    private String arTermsCondition;
    @SerializedName("en_terms_condition")
    @Expose
    private Object enTermsCondition;
    @SerializedName("privacy_policy")
    @Expose
    private String privacyPolicy;
    @SerializedName("site_commission")
    @Expose
    private Integer siteCommission;
    @SerializedName("debt_limt")
    @Expose
    private Integer debtLimt;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private Object desc;
    @SerializedName("about_app")
    @Expose
    private String aboutApp;
    @SerializedName("terms_condition")
    @Expose
    private String termsCondition;
    private final static long serialVersionUID = -3472291635237931293L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getTermsConditionLink() {
        return termsConditionLink;
    }

    public void setTermsConditionLink(Object termsConditionLink) {
        this.termsConditionLink = termsConditionLink;
    }

    public Object getAboutUsLink() {
        return aboutUsLink;
    }

    public void setAboutUsLink(Object aboutUsLink) {
        this.aboutUsLink = aboutUsLink;
    }

    public Object getPrivacyPolicyLink() {
        return privacyPolicyLink;
    }

    public void setPrivacyPolicyLink(Object privacyPolicyLink) {
        this.privacyPolicyLink = privacyPolicyLink;
    }

    public String getHeaderLogo() {
        return headerLogo;
    }

    public void setHeaderLogo(String headerLogo) {
        this.headerLogo = headerLogo;
    }

    public String getFooterLogo() {
        return footerLogo;
    }

    public void setFooterLogo(String footerLogo) {
        this.footerLogo = footerLogo;
    }

    public Object getLoginBanner() {
        return loginBanner;
    }

    public void setLoginBanner(Object loginBanner) {
        this.loginBanner = loginBanner;
    }

    public Object getImageSlider() {
        return imageSlider;
    }

    public void setImageSlider(Object imageSlider) {
        this.imageSlider = imageSlider;
    }

    public String getArTitle() {
        return arTitle;
    }

    public void setArTitle(String arTitle) {
        this.arTitle = arTitle;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public Object getArDesc() {
        return arDesc;
    }

    public void setArDesc(Object arDesc) {
        this.arDesc = arDesc;
    }

    public Object getEnDesc() {
        return enDesc;
    }

    public void setEnDesc(Object enDesc) {
        this.enDesc = enDesc;
    }

    public Object getArFooterDesc() {
        return arFooterDesc;
    }

    public void setArFooterDesc(Object arFooterDesc) {
        this.arFooterDesc = arFooterDesc;
    }

    public Object getEnFooterDesc() {
        return enFooterDesc;
    }

    public void setEnFooterDesc(Object enFooterDesc) {
        this.enFooterDesc = enFooterDesc;
    }

    public Object getCompanyProfilePdf() {
        return companyProfilePdf;
    }

    public void setCompanyProfilePdf(Object companyProfilePdf) {
        this.companyProfilePdf = companyProfilePdf;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public Object getFax() {
        return fax;
    }

    public void setFax(Object fax) {
        this.fax = fax;
    }

    public String getAndroidApp() {
        return androidApp;
    }

    public void setAndroidApp(String androidApp) {
        this.androidApp = androidApp;
    }

    public String getIosApp() {
        return iosApp;
    }

    public void setIosApp(String iosApp) {
        this.iosApp = iosApp;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }

    public Object getSmsUserName() {
        return smsUserName;
    }

    public void setSmsUserName(Object smsUserName) {
        this.smsUserName = smsUserName;
    }

    public Object getSmsUserPass() {
        return smsUserPass;
    }

    public void setSmsUserPass(Object smsUserPass) {
        this.smsUserPass = smsUserPass;
    }

    public Object getSmsSender() {
        return smsSender;
    }

    public void setSmsSender(Object smsSender) {
        this.smsSender = smsSender;
    }

    public Object getPublisher() {
        return publisher;
    }

    public void setPublisher(Object publisher) {
        this.publisher = publisher;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public Object getDefaultTheme() {
        return defaultTheme;
    }

    public void setDefaultTheme(Object defaultTheme) {
        this.defaultTheme = defaultTheme;
    }

    public Object getOfferMuted() {
        return offerMuted;
    }

    public void setOfferMuted(Object offerMuted) {
        this.offerMuted = offerMuted;
    }

    public Integer getOfferNotification() {
        return offerNotification;
    }

    public void setOfferNotification(Integer offerNotification) {
        this.offerNotification = offerNotification;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getGooglePlus() {
        return googlePlus;
    }

    public void setGooglePlus(String googlePlus) {
        this.googlePlus = googlePlus;
    }

    public String getSnapchatGhost() {
        return snapchatGhost;
    }

    public void setSnapchatGhost(String snapchatGhost) {
        this.snapchatGhost = snapchatGhost;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getArAboutApp() {
        return arAboutApp;
    }

    public void setArAboutApp(String arAboutApp) {
        this.arAboutApp = arAboutApp;
    }

    public Object getEnAboutApp() {
        return enAboutApp;
    }

    public void setEnAboutApp(Object enAboutApp) {
        this.enAboutApp = enAboutApp;
    }

    public String getArTermsCondition() {
        return arTermsCondition;
    }

    public void setArTermsCondition(String arTermsCondition) {
        this.arTermsCondition = arTermsCondition;
    }

    public Object getEnTermsCondition() {
        return enTermsCondition;
    }

    public void setEnTermsCondition(Object enTermsCondition) {
        this.enTermsCondition = enTermsCondition;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public Integer getSiteCommission() {
        return siteCommission;
    }

    public void setSiteCommission(Integer siteCommission) {
        this.siteCommission = siteCommission;
    }

    public Integer getDebtLimt() {
        return debtLimt;
    }

    public void setDebtLimt(Integer debtLimt) {
        this.debtLimt = debtLimt;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getAboutApp() {
        return aboutApp;
    }

    public void setAboutApp(String aboutApp) {
        this.aboutApp = aboutApp;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(String termsCondition) {
        this.termsCondition = termsCondition;
    }

}
