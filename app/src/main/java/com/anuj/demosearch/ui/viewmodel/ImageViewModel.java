package com.anuj.demosearch.ui.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import com.anuj.demosearch.business.model.ImageDomainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Image view model, which is used to display Image data on view.
 * @see com.anuj.demosearch.business.dto.Image for response model details.
 */
public class ImageViewModel implements Parcelable {

    @NonNull private final String mSize;
    @NonNull private final String mImageUrl;

    private ImageViewModel(@NonNull final ImageDomainModel domainModel) {
        mSize = domainModel.getSize();
        mImageUrl = domainModel.getUrl();
    }

    private ImageViewModel(Parcel in) {
        mSize = in.readString();
        mImageUrl = in.readString();
    }

    public static final Creator<ImageViewModel> CREATOR = new Creator<ImageViewModel>() {
        @Override
        public ImageViewModel createFromParcel(Parcel in) {
            return new ImageViewModel(in);
        }

        @Override
        public ImageViewModel[] newArray(int size) {
            return new ImageViewModel[size];
        }
    };

    @NonNull
    static List<ImageViewModel> fromList(@NonNull final List<ImageDomainModel> images) {
        final List<ImageViewModel> mList = new ArrayList<>();
        for (ImageDomainModel imageDomainModel : images) {
            mList.add(new ImageViewModel(imageDomainModel));
        }
        return mList;
    }

    @NonNull
    public String getSize() {
        return mSize;
    }

    @NonNull
    public String getImageUrl() {
        return mImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSize);
        dest.writeString(mImageUrl);
    }
}
