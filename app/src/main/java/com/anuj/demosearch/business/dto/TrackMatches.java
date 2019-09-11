package com.anuj.demosearch.business.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackMatches {
    @SerializedName("track")
    private List<Track> mTracks;

    public List<Track> getTracks() {
        return mTracks;
    }
}
