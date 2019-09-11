package com.anuj.demosearch.ui.usecase;

import com.anuj.demosearch.BuildConfig;
import com.anuj.demosearch.business.dto.Image;
import com.anuj.demosearch.business.dto.Track;
import com.anuj.demosearch.business.network.SearchApi;
import com.anuj.demosearch.ui.SearchArguments;
import com.anuj.demosearch.ui.viewmodel.TrackViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchResultsUseCaseTest {

    private static final String SEARCH_KEYWORD = "Keyword";
    private static final int SOME_INT = 1;
    private static final String SOME_ARTIST = "SOME_ARTIST";
    private static final String SOME_LISTENERS = "SOME_LISTENERS";
    private static final String SOME_NAME = "SOME_NAME";
    private static final String SOME_URL = "SOME_URL";

    @Mock SearchApi mSearchApi;
    @Mock Track mTrack;
    @Mock Image mImage;

    private SearchResultsUseCase mSearchResultsUseCase;

    @Before
    public void setup() {
        mSearchResultsUseCase = new SearchResultsUseCase(mSearchApi);
    }

    @Test
    public void searchTracks_whenCalled_shouldCallServiceApi() {
        mSearchResultsUseCase.searchTracks(SEARCH_KEYWORD, SOME_INT, SOME_INT);

        verify(mSearchApi).searchTracks(BuildConfig.API_KEY,
                SearchArguments.TRACK.getMethodName(),
                SEARCH_KEYWORD,
                SOME_INT,
                SOME_INT);
    }

    @Test
    public void getViewModels_whenCalled_shouldReturnViewModelList() {
        when(mTrack.getArtist()).thenReturn(SOME_ARTIST);
        when(mTrack.getImage()).thenReturn(Collections.singletonList(mImage));
        when(mTrack.getListeners()).thenReturn(SOME_LISTENERS);
        when(mTrack.getName()).thenReturn(SOME_NAME);
        when(mTrack.getUrl()).thenReturn(SOME_URL);

        final List<TrackViewModel> viewModels =
                mSearchResultsUseCase.getViewModels(Collections.singletonList(mTrack));

        final int index = 0;
        assertEquals(SOME_ARTIST, viewModels.get(index).getArtistName());
        assertEquals(SOME_NAME, viewModels.get(index).getName());
        assertEquals(SOME_URL, viewModels.get(index).getUrl());
    }
}