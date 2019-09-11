package com.anuj.demosearch.business.model;

import androidx.annotation.NonNull;
import com.anuj.demosearch.business.dto.Results;

public class ResultsDomainModel {
    @NonNull private final TrackMatchesDomainModel mTrackMatches;

    public ResultsDomainModel(@NonNull final Results results) {
        mTrackMatches = new TrackMatchesDomainModel(results.getTrackMatches());
    }

    @NonNull
    public TrackMatchesDomainModel getTrackMatches() {
        return mTrackMatches;
    }
}
