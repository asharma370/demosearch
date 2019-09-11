package com.anuj.demosearch.business.dto;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("#text")
    private String mUrl;

    @SerializedName("size")
    private String mSize;

    public String getUrl() {
        return mUrl;
    }

    public String getSize() {
        return mSize;
    }
}
