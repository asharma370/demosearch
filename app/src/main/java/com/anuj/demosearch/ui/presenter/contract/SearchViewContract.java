package com.anuj.demosearch.ui.presenter.contract;

import androidx.annotation.NonNull;

/**
 * Contract details for search view.
 *
 * @see com.anuj.demosearch.ui.fragment.SearchFragment for more details.
 */
public interface SearchViewContract {
    interface View extends BaseViewContract {
        /**
         * Display search results view.
         *
         * @param searchKeyword Pass search keyword to view.
         */
        void displaySearchResultsView(@NonNull String searchKeyword);
    }

    interface Presenter extends BasePresenterContract<SearchViewContract.View> {
        /**
         * Method to handle the click listener of search button.
         *
         * @param connectedToInternet
         * @param empty
         * @param searchKeyword Pass search keyword.
         */
        void onClickSearchButton(boolean connectedToInternet, boolean empty, @NonNull final String searchKeyword);
    }
}
