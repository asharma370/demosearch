package com.anuj.demosearch.ui.presenter.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anuj.demosearch.ui.viewmodel.TrackViewModel;

import java.util.List;

/**
 * Contract details for search results fragment.
 *
 * @see com.anuj.demosearch.ui.fragment.SearchResultsFragment
 */
public interface SearchResultsContract {
    interface View extends BaseViewContract {
        /**
         * Display search results on the view.
         *
         * @param results Search results view model.
         */
        void displaySearchResults(@NonNull List<TrackViewModel> results);
    }

    interface Presenter extends BasePresenterContract<SearchResultsContract.View> {
        /**
         * Search data from API.
         *
         * @param searchKeyword Search keyword.
         */
        void searchData(@Nullable final String searchKeyword);
    }
}
