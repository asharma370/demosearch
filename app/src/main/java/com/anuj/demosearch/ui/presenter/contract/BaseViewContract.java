package com.anuj.demosearch.ui.presenter.contract;

import androidx.annotation.StringRes;

/**
 * Base view contract, should be extended by the view contract.
 * @see SearchResultsContract.View for more details.
 */
public interface BaseViewContract {
    /**
     * To show messages on view.
     *
     * @param errorMsg Integer string resource.
     */
    void showMessage(@StringRes final int errorMsg);

    /**
     * Hide progress loading.
     */
    void hideLoading();

    /**
     * Show progress loading.
     */
    void showLoading();
}
