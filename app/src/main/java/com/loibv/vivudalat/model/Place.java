package com.loibv.vivudalat.model;

import android.media.Image;

/**
 * Created by vanloibui on 12/21/15.
 */
public class Place {
    private String name;
    private int imageId;

    public Place(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
