package com.semicode.findsolution.model;

public class MenuMoudel {
    String Tittle;
    String image;

    public MenuMoudel(String tittle, String image) {
        Tittle = tittle;
        this.image = image;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
