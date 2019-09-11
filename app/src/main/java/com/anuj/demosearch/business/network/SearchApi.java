package com.anuj.demosearch.business.network;

import com.anuj.demosearch.business.dto.SearchResults;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApi {

    @GET("2.0/?format=json")
    Single<SearchResults> searchTracks(@Query("api_key") String apiKey,
                                       @Query("method") String searchMethod,
                                       @Query("track") String track,
                                       @Query("limit") int limit,
                                       @Query("page") int page);
}
