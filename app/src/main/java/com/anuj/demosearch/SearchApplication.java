package com.anuj.demosearch;

import android.app.Application;

import com.anuj.demosearch.business.di.AppInjector;

public class SearchApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }
}
