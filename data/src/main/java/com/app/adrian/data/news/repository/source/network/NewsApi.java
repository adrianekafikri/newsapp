package com.app.adrian.data.news.repository.source.network;

import com.app.adrian.data.news.NewsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public interface NewsApi {

    @GET("/v2/sources")
    Observable<NewsResponse> getNewsSource(@Query("apiKey") String apiKey);

    @GET("/v2/everything")
    Observable<NewsResponse> getNewsArticle(@Query("sources") String domain,
                                            @Query("apiKey") String apiKey,
                                            @Query("page") int page);

    @GET("/v2/everything")
    Observable<NewsResponse> searchArticle(@Query("q") String keyword,
                                           @Query("apiKey") String apiKey,
                                           @Query("page") int page);
}
