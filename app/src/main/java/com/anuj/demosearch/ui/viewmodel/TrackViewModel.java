package com.anuj.demosearch.ui.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.anuj.demosearch.business.model.TrackDomainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Track view model, used by view to display track details.
 * @see com.anuj.demosearch.business.dto.Track for response details.
 */
public class TrackViewModel implements Parcelable {

    private static final String EMPTY_STRING = "";

    @NonNull private final String mArtistName;
    @NonNull private final List<ImageViewModel> mImage;
    @NonNull private final String mListeners;
    @NonNull private final String mName;
    @NonNull private final String mUrl;
    @NonNull private final String mStreamable;

    private static final int SMALL_IMAGE_IDX = 0;
    private static final int LARGE_IMAGE_IDX = 2;

    private TrackViewModel(@NonNull final TrackDomainModel domainModel){
        mArtistName = domainModel.getArtist();
        mListeners = domainModel.getListeners();
        mName = domainModel.getName();
        mUrl = domainModel.getUrl();
        mImage = ImageViewModel.fromList(domainModel.getImage());
        mStreamable = domainModel.getStreamable();
    }

    public static List<TrackViewModel> fromDomainModel(@NonNull final List<TrackDomainModel> trackDomainModel) {
        final List<TrackViewModel> mList = new ArrayList<>();
        for (TrackDomainModel domainModel : trackDomainModel) {
            mList.add(new TrackViewModel(domainModel));
        }
        return mList;
    }

    private TrackViewModel(Parcel in) {
        mArtistName = in.readString();
        mImage = in.createTypedArrayList(ImageViewModel.CREATOR);
        mListeners = in.readString();
        mName = in.readString();
        mUrl = in.readString();
        mStreamable = in.readString();
    }

    public static final Creator<TrackViewModel> CREATOR = new Creator<TrackViewModel>() {
        @Override
        public TrackViewModel createFromParcel(Parcel in) {
            return new TrackViewModel(in);
        }

        @Override
        public TrackViewModel[] newArray(int size) {
            return new TrackViewModel[size];
        }
    };

    @NonNull
    public List<ImageViewModel> getImage() {
        return mImage;
    }

    @NonNull
    public String getSmallImage() {
        if (!mImage.isEmpty()) {
            return mImage.get(SMALL_IMAGE_IDX).getImageUrl();
        }
        return EMPTY_STRING;
    }

    @NonNull
    public String getLargeImage() {
        if (!mImage.isEmpty() && LARGE_IMAGE_IDX < mImage.size()) {
            return mImage.get(LARGE_IMAGE_IDX).getImageUrl();
        }
        return EMPTY_STRING;
    }

    @NonNull
    public String getArtistName() {
        return mArtistName;
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
    public String getStreamable() {
        return mStreamable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mArtistName);
        dest.writeTypedList(mImage);
        dest.writeString(mListeners);
        dest.writeString(mName);
        dest.writeString(mUrl);
        dest.writeString(mStreamable);
    }
}
