package com.anuj.demosearch.ui.presenter.contract;

import androidx.annotation.NonNull;

/**
 * Base contract for presenter,
 * should be extended by the presenter contract.
 * @see SearchResultsContract.Presenter for more details.
 */
public interface BasePresenterContract<T extends BaseViewContract> {
    /**
     * Method to attach your view to your presenter.
     * @param view View for presenter.
     */
    void onAttach(@NonNull T view);
}
