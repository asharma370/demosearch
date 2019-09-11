package com.anuj.demosearch.business.model;

import androidx.annotation.NonNull;
import com.anuj.demosearch.business.dto.SearchResults;

public class SearchResultsDomainModel {

    @NonNull private final ResultsDomainModel mResults;
    private final int mTotalResults;

    public SearchResultsDomainModel(@NonNull final SearchResults searchResults) {
        mResults = new ResultsDomainModel(searchResults.getResults());
        mTotalResults = searchResults.getTotalResults();
    }

    @NonNull
    public ResultsDomainModel getResults() {
        return mResults;
    }

    @NonNull
    public int getTotalResults() {
        return mTotalResults;
    }
}
