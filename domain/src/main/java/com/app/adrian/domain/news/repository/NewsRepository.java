package com.app.adrian.domain.news.repository;

import com.app.adrian.domain.news.Article;
import com.app.adrian.domain.news.Source;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public interface NewsRepository {

    Observable<List<Source>> getSources();

    Observable<List<Article>> getArticles(String domain, int page);

    Observable<Integer> getTotalResult();

    Observable<List<Article>> searchArticle(String keyword, int page);
}
