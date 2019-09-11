package com.anuj.demosearch.business.dto;

import com.google.gson.annotations.SerializedName;

public class SearchResults {

    @SerializedName("totalResults")
    private int mTotalResults;

    @SerializedName("results")
    private Results mResults;

    public Results getResults() {
        return mResults;
    }

    public int getTotalResults() {
        return mTotalResults;
    }
}
