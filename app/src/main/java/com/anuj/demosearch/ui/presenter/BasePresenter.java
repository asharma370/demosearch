package com.anuj.demosearch.ui.presenter;

import androidx.annotation.NonNull;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Base presenter class should be used by all presenter classes,
 * provides important method for presenter.
 */
public class BasePresenter {
    private final CompositeDisposable mCompositeDisposable;

    BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    /**
     * Use this method to add request to composite disposable.
     *
     * @param disposable Disposable request.
     */
    void addSubscription(@NonNull final Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    /**
     * Generic scheduler method, adds scheduler to request
     * very handy to use and calling method looks neat.
     *
     * @param <T> Downstream
     * @return Observable.
     */
    <T> SingleTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * On destroy, presenter should dispose the composite disposable.
     */
    public void onDestroy() {
        mCompositeDisposable.dispose();
    }
}
