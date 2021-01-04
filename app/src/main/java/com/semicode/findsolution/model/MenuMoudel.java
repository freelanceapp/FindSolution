package com.semicode.findsolution.model;

import android.graphics.drawable.Drawable;

public class MenuMoudel {
    String Tittle;
    Drawable image;

    public MenuMoudel(String tittle, Drawable image) {
        Tittle = tittle;
        this.image = image;
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
}
