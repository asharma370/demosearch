package com.anuj.demosearch.ui.presenter;

import android.content.Context;

import com.anuj.demosearch.R;
import com.anuj.demosearch.business.dto.Results;
import com.anuj.demosearch.business.dto.SearchResults;
import com.anuj.demosearch.business.dto.Track;
import com.anuj.demosearch.business.dto.TrackMatches;
import com.anuj.demosearch.ui.usecase.SearchResultsUseCase;
import com.anuj.demosearch.ui.viewmodel.TrackViewModel;
import com.anuj.demosearch.ui.presenter.contract.SearchResultsContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchResultsPresenterTest {

    private static final String SEARCH_KEYWORD = "keyword";
    @Mock
    SearchResultsUseCase mSearchResultUseCase;
    @Mock SearchResultsContract.View mView;
    @Mock SearchResults mSearchResults;
    @Mock Results mResults;
    @Mock TrackMatches mTrackMatches;
    @Mock List<Track> mTracks;
    @Mock List<TrackViewModel> mTracksViewModel;
    @Mock Context mContext;

    private SearchResultsPresenter mPresenter;

    @Before
    public void setup() {
        mockRxJava();
        mPresenter = new SearchResultsPresenter(mSearchResultUseCase);
        mPresenter.onAttach(mView);
    }

    private void mockRxJava() {
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Test
    public void searchData_whenSuccessCall_shouldDisplayLoadingAndSetData() {
        when(mTrackMatches.getTracks()).thenReturn(mTracks);
        when(mResults.getTrackMatches()).thenReturn(mTrackMatches);
        when(mSearchResults.getResults()).thenReturn(mResults);
        when(mSearchResultUseCase.searchTracks(anyString(), anyInt(), anyInt()))
                .thenReturn(Single.just(mSearchResults));
        when(mSearchResultUseCase.getViewModels(mTracks)).thenReturn(mTracksViewModel);

        mPresenter.searchData(SEARCH_KEYWORD);

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).displaySearchResults(any());
    }

    @Test
    public void searchData_whenErrorCall_shouldDisplayErrorMessage() {
        when(mContext.getString(anyInt())).thenReturn("Some message");
        when(mSearchResultUseCase.searchTracks(anyString(), anyInt(), anyInt()))
                .thenReturn(Single.error(new Throwable("An error has occurred!")));

        mPresenter.searchData(SEARCH_KEYWORD);

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).showMessage(R.string.error_something_went_wrong);
    }
}