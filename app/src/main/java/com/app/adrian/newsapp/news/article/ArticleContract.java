package com.app.adrian.newsapp.news.article;

import com.app.adrian.newsapp.base.BaseContractView;
import com.app.adrian.newsapp.news.model.ArticleModel;

import java.util.List;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public interface ArticleContract {

    interface View extends BaseContractView {
        void onArticleLoaded(List<ArticleModel> articleModels);
        void clearAdapter();
    }

    interface Presenter {
        void loadArticle(String source, int size);
        void searchArticle(String q, int size);
    }
}
