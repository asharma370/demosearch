package com.anuj.demosearch.business.di;

import androidx.annotation.NonNull;

import com.anuj.demosearch.SearchApplication;

public class AppInjector {
    private static ApplicationComponent mApplicationComponentInstance;

    public static ApplicationComponent getInstance() {
        return mApplicationComponentInstance;
    }

    public static void init(@NonNull final SearchApplication application) {
        mApplicationComponentInstance = DaggerApplicationComponent.builder()
                .application(application)
                .context(application)
                .build();
    }
}