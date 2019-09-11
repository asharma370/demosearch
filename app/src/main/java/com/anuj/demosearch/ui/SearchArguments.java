package com.anuj.demosearch.ui;

import androidx.annotation.NonNull;

/**
 * Search arguments enum, provides name and method name.
 * Can be used in future if we want to scale the application
 * functionality to albums and artists.
 */
public enum SearchArguments {

    TRACK("TRACK", "track.search"),
    ARTIST("ARTIST", "artist.search"),
    ALBUM("ALBUM", "album.search");

    @NonNull private String mArgumentName;
    @NonNull private String mMethodName;

    SearchArguments(@NonNull final String argumentName, @NonNull final String methodName) {
        mArgumentName = argumentName;
        mMethodName = methodName;
    }

    @NonNull
    public String getArgumentName() {
        return mArgumentName;
    }

    @NonNull
    public String getMethodName() {
        return mMethodName;
    }
}
