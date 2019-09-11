package com.anuj.demosearch.business.di;

import com.anuj.demosearch.business.network.NetworkApiFactory;
import com.anuj.demosearch.business.network.RetrofitApiFactory;
import com.anuj.demosearch.business.network.SearchApi;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @AppScope
    NetworkApiFactory getNetworkApiFactory(RetrofitApiFactory retrofitApiFactory) {
        return new NetworkApiFactory(retrofitApiFactory);
    }

    @Provides
    @AppScope
    SearchApi getSearchApi(NetworkApiFactory networkApiFactory) {
        return networkApiFactory.getApi();
    }

    @Provides
    @AppScope
    RetrofitApiFactory getRetrofitApiFactory() {
        return new RetrofitApiFactory();
    }

}
