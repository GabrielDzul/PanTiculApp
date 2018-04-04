package com.kokomusoft.panticul.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Gabriel on 19/04/2015.
 */
public class Proposal {
    private Drawable image;
    private String title;
    private String description;
    private String category;

    public Proposal(Drawable image, String title, String description, String category) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public Proposal(Drawable image, String title, String category) {
        this.image = image;
        this.title = title;
        this.category = category;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
