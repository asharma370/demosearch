package com.anuj.demosearch.business.dto;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("trackmatches")
    private TrackMatches mTrackMatches;

    public TrackMatches getTrackMatches() {
        return mTrackMatches;
    }
}
