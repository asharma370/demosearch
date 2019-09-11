package com.anuj.demosearch.ui.presenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anuj.demosearch.R;
import com.anuj.demosearch.business.dto.Track;
import com.anuj.demosearch.ui.presenter.contract.SearchResultsContract;
import com.anuj.demosearch.ui.usecase.SearchResultsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Search result presenter for search result views.
 * @see com.anuj.demosearch.ui.fragment.SearchResultsFragment for more details.
 */
public class SearchResultsPresenter extends BasePresenter implements SearchResultsContract.Presenter {

    private SearchResultsContract.View mView;
    private final SearchResultsUseCase mSearchResultsUseCase;
    private static final int PAGE_SIZE = 50;
    private static final int PAGE_NUMBER = 1;

    @Inject
    public SearchResultsPresenter(SearchResultsUseCase searchResultsUseCase) {
        mSearchResultsUseCase = searchResultsUseCase;
    }

    @Override
    public void onAttach(@NonNull final SearchResultsContract.View view) {
        mView = view;
    }

    @Override
    public void searchData(@Nullable final String searchKeyword) {
        final Disposable disposable = mSearchResultsUseCase
                .searchTracks(searchKeyword, PAGE_SIZE, PAGE_NUMBER)
                .compose(applySchedulers())
                .doOnSubscribe(disposable1 -> {
                    mView.showLoading();
                })
                .doOnTerminate(() -> {
                    mView.hideLoading();
                })
                .subscribe(searchResults -> {
                    final List<Track> tracks = searchResults.getResults().getTrackMatches().getTracks();
                    mView.displaySearchResults(mSearchResultsUseCase.getViewModels(tracks));
                }, throwable -> {
                    mView.showMessage(R.string.error_something_went_wrong);
                });
        addSubscription(disposable);
    }
}
