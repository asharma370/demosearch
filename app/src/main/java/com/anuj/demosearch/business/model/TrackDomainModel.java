package com.anuj.demosearch.business.model;

import androidx.annotation.NonNull;
import com.anuj.demosearch.business.dto.Track;
import java.util.ArrayList;
import java.util.List;

public class TrackDomainModel {

    @NonNull private final String mArtist;
    @NonNull private final String mListeners;
    @NonNull private final String mName;
    @NonNull private final String mUrl;
    @NonNull private final List<ImageDomainModel> mImage;
    @NonNull private final String mStreamable;

    private TrackDomainModel(@NonNull final Track track) {
        mArtist = track.getArtist();
        mListeners = track.getListeners();
        mName = track.getName();
        mUrl = track.getUrl();
        mImage = ImageDomainModel.getImages(track.getImage());
        mStreamable = track.getStreamable();
    }

    @NonNull
    public String getArtist() {
        return mArtist;
    }

    @NonNull
    public String getListeners() {
        return mListeners;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getUrl() {
        return mUrl;
    }

    @NonNull
    public List<ImageDomainModel> getImage() {
        return mImage;
    }

    @NonNull
    public String getStreamable() {
        return mStreamable;
    }

    public static List<TrackDomainModel> fromTracks(@NonNull final List<Track> tracks) {
        final List<TrackDomainModel> trackList = new ArrayList<>();
        for (Track track : tracks) {
            trackList.add(new TrackDomainModel(track));
        }
        return trackList;
    }
}
