package com.anuj.demosearch.business.network;

import androidx.annotation.NonNull;

public class NetworkApiFactory {

    private final RetrofitApiFactory mRetrofitApiFactory;

    public NetworkApiFactory(@NonNull final RetrofitApiFactory retrofitApiFactory){
        mRetrofitApiFactory = retrofitApiFactory;
    }

    public SearchApi getApi() {
        return mRetrofitApiFactory.createService(SearchApi.class);
    }
}
