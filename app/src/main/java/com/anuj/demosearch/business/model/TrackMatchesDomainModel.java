package com.anuj.demosearch.business.model;

import androidx.annotation.NonNull;
import com.anuj.demosearch.business.dto.TrackMatches;
import java.util.List;

public class TrackMatchesDomainModel {

    @NonNull private final List<TrackDomainModel> mTracks;

    public TrackMatchesDomainModel(@NonNull final TrackMatches trackMatches) {
        mTracks = TrackDomainModel.fromTracks(trackMatches.getTracks());
    }

    @NonNull
    public List<TrackDomainModel> getTracks() {
        return mTracks;
    }
}
