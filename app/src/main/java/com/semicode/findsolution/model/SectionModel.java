package com.semicode.findsolution.model;

public class SectionModel {
    private String sectionName;
    private int sectionImage;
    public boolean isSelected = false;

    public SectionModel(String sectionName, int sectionImage) {
        this.sectionName = sectionName;
        this.sectionImage = sectionImage;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getSectionImage() {
        return sectionImage;
    }

    public void setSectionImage(int sectionImage) {
        this.sectionImage = sectionImage;
    }

    public void setSelected() {
        this.isSelected = true;
    }

    public void setNotSelected() {
        this.isSelected = false;
    }
}
