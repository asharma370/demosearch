package com.anuj.demosearch.ui.presenter;

import androidx.annotation.NonNull;

import com.anuj.demosearch.R;
import com.anuj.demosearch.ui.presenter.contract.SearchViewContract;
import javax.inject.Inject;

/**
 * Presenter for search view fragment.
 *
 * @see com.anuj.demosearch.ui.fragment.SearchFragment for more details.
 */
public class SearchViewPresenter implements SearchViewContract.Presenter {

    private SearchViewContract.View mView;

    @Inject
    SearchViewPresenter() {
        //Not in use.
    }

    @Override
    public void onAttach(@NonNull final SearchViewContract.View view) {
        mView = view;
    }

    @Override
    public void onClickSearchButton(boolean empty, @NonNull final String searchKeyword) {
        if (empty) {
            mView.showMessage(R.string.error_search_keyword_empty);
        } else {
            mView.displaySearchResultsView(searchKeyword);
        }
    }
}
