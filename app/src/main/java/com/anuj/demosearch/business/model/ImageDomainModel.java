package com.anuj.demosearch.business.model;

import androidx.annotation.NonNull;

import com.anuj.demosearch.business.dto.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain model for response model.
 * @see Image is the response model.
 */
public class ImageDomainModel {

    @NonNull private final String mUrl;
    @NonNull private final String mSize;

    private ImageDomainModel(@NonNull final Image image) {
        mUrl = image.getUrl();
        mSize = image.getSize();
    }

    @NonNull
    public String getSize() {
        return mSize;
    }

    @NonNull
    public String getUrl() {
        return mUrl;
    }

    @NonNull
    static List<ImageDomainModel> getImages(@NonNull final List<Image> images) {
        final List<ImageDomainModel> imageList = new ArrayList<>();
        for (Image image : images) {
            imageList.add(new ImageDomainModel(image));
        }
        return imageList;
    }
}
