package com.app.adrian.data.news.repository.source.network;

import com.app.adrian.data.BuildConfig;
import com.app.adrian.data.network.BaseNetwork;
import com.app.adrian.data.news.ArticleEntity;
import com.app.adrian.data.news.NewsResponse;
import com.app.adrian.data.news.SourceEntity;
import com.app.adrian.data.news.repository.source.NewsEntityData;
import com.app.adrian.domain.news.Article;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public class NetworkNewsEntityData extends BaseNetwork<NewsApi> implements NewsEntityData {

    @Override
    protected Class<NewsApi> getNetworkClass() {
        return NewsApi.class;
    }

    @Override
    protected String getBaseUrl() {
        return "https://newsapi.org";
    }

    @Override
    public Observable<List<SourceEntity>> getSources() {
        return getNetworkService().getNewsSource(BuildConfig.NewsApiKey)
                .subscribeOn(Schedulers.io())
                .map(newsResponse -> newsResponse.sources);
    }

    @Override
    public Observable<NewsResponse> getArticles(String source, int page) {
        return getNetworkService().getNewsArticle(source, BuildConfig.NewsApiKey, page)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<NewsResponse> searchArticle(String keyword, int page) {
        return getNetworkService().searchArticle(keyword, BuildConfig.NewsApiKey, page)
                .subscribeOn(Schedulers.io());
    }
}
