package com.anuj.demosearch.ui.usecase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anuj.demosearch.BuildConfig;
import com.anuj.demosearch.business.dto.SearchResults;
import com.anuj.demosearch.business.dto.Track;
import com.anuj.demosearch.business.model.TrackDomainModel;
import com.anuj.demosearch.business.network.SearchApi;
import com.anuj.demosearch.ui.SearchArguments;
import com.anuj.demosearch.ui.viewmodel.TrackViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class SearchResultsUseCase {

    private final SearchApi mSearchApi;

    @Inject
    public SearchResultsUseCase(@NonNull SearchApi searchApi) {
        mSearchApi = searchApi;
    }

    public Single<SearchResults> searchTracks(@Nullable final String searchKeyword,
                                       final int pageSize,
                                       final int pageNum) {
        return mSearchApi.searchTracks(BuildConfig.API_KEY,
                SearchArguments.TRACK.getMethodName(),
                searchKeyword,
                pageSize,
                pageNum);
    }

    @NonNull
    public List<TrackViewModel> getViewModels(@NonNull final List<Track> tracks) {
        return TrackViewModel.fromDomainModel(TrackDomainModel.fromTracks(tracks));
    }
}
