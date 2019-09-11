package com.anuj.demosearch.business.network;

import androidx.annotation.NonNull;

import com.anuj.demosearch.BuildConfig;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit factory class, configure and provides service.
 */
public class RetrofitApiFactory {

    private final Retrofit mRetrofit;

    public RetrofitApiFactory() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.DOMAIN_URL)
                .client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    private OkHttpClient getClient() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    <T> T createService(@NonNull final Class<T> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}