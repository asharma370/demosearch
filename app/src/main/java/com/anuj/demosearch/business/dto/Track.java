package com.anuj.demosearch.business.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track {
    @SerializedName("name")
    private String mName;

    @SerializedName("artist")
    private String mArtist;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("listeners")
    private String mListeners;

    @SerializedName("image")
    private List<Image> mImage;

    @SerializedName("streamable")
    private String mStreamable;

    public String getName() {
        return mName;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getListeners() {
        return mListeners;
    }

    public List<Image> getImage() {
        return mImage;
    }

    public String getStreamable() {
        return mStreamable;
    }
}
