package com.semicode.findsolution.model;

import android.graphics.drawable.Drawable;

public class MenuModel {
    String Tittle;
    Drawable image ,imageSelected;

    public MenuModel(String tittle, Drawable image , Drawable imageSelected) {
        Tittle = tittle;
        this.image = image;
        this.imageSelected = imageSelected;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
    public void setImageSelected(Drawable image) {
        this.imageSelected = image;
    }

    public Drawable getImageSelected() {
        return this.imageSelected;
    }
}
