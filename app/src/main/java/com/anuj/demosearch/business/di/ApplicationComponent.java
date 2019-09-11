package com.anuj.demosearch.business.di;

import android.app.Application;
import android.content.Context;
import com.anuj.demosearch.ui.fragment.SearchFragment;
import com.anuj.demosearch.ui.fragment.SearchResultsFragment;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {NetworkModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(final Application application);

        @BindsInstance
        Builder context(final Context context);

        ApplicationComponent build();

    }

    void inject(final SearchFragment searchFragment);

    void inject(final SearchResultsFragment searchFragment);
}