package com.app.adrian.data.news.repository.source;

import com.app.adrian.data.news.ArticleEntity;
import com.app.adrian.data.news.NewsResponse;
import com.app.adrian.data.news.SourceEntity;
import com.app.adrian.domain.news.Article;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public interface NewsEntityData {

    Observable<List<SourceEntity>> getSources();

    Observable<NewsResponse> getArticles(String domain, int page);

    Observable<NewsResponse> searchArticle(String keyword, int page);
}
