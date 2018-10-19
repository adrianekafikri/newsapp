package com.app.adrian.newsapp.news.article;

import com.app.adrian.domain.news.Article;
import com.app.adrian.domain.news.interactor.GetArticleUseCase;
import com.app.adrian.domain.news.interactor.GetTotalResultUseCase;
import com.app.adrian.domain.news.interactor.SearchArticleUseCase;
import com.app.adrian.newsapp.base.BasePresenter;
import com.app.adrian.newsapp.news.model.ArticleModelMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public class ArticlePresenter extends BasePresenter<ArticleContract.View>
        implements ArticleContract.Presenter {

    private int totalResult;

    private final GetArticleUseCase getArticleUseCase;

    private final ArticleModelMapper articleModelMapper;

    private final GetTotalResultUseCase getTotalResultUseCase;

    private final SearchArticleUseCase searchArticleUseCase;

    @Inject
    public ArticlePresenter(GetArticleUseCase getArticleUseCase,
                            ArticleModelMapper articleModelMapper,
                            GetTotalResultUseCase getTotalResultUseCase,
                            SearchArticleUseCase searchArticleUseCase) {
        this.getArticleUseCase = getArticleUseCase;
        this.articleModelMapper = articleModelMapper;
        this.getTotalResultUseCase = getTotalResultUseCase;
        this.searchArticleUseCase = searchArticleUseCase;
    }

    @Override
    public void loadArticle(String source, int size) {
        if (size > totalResult) return;

        getView().showProgressBar();

        int page = (int) Math.floor(size/20) + 1;

        getArticleUseCase.execute(new DisposableObserver<List<Article>>() {
            @Override
            public void onNext(List<Article> articles) {
                getView().hideProgressBar();
                getView().onArticleLoaded(articleModelMapper.transform(articles));

                if (totalResult <= 0) {
                    getTotalResult();
                }
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
            }

            @Override
            public void onComplete() {
                getView().hideProgressBar();
            }
        }, GetArticleUseCase.Param.setParams(source, page));
    }

    @Override
    public void searchArticle(String q, int size) {
        if (size > totalResult) return;

        int page = (int) Math.floor(size/20) + 1;
        if (page <= 1) getView().clearAdapter();

        getView().showProgressBar();

        searchArticleUseCase.execute(new DisposableObserver<List<Article>>() {
            @Override
            public void onNext(List<Article> articles) {
                getView().hideProgressBar();
                getView().onArticleLoaded(articleModelMapper.transform(articles));

                if (totalResult <= 0) {
                    getTotalResult();
                }
            }

            @Override
            public void onError(Throwable e) {
                getView().hideProgressBar();
            }

            @Override
            public void onComplete() {
                getView().hideProgressBar();
            }
        }, SearchArticleUseCase.Param.setParams(q, page));
    }

    private void getTotalResult() {
        getTotalResultUseCase.execute(new DisposableObserver<Integer>() {
            @Override
            public void onNext(Integer totalResult) {
                if (totalResult > 0) {
                    ArticlePresenter.this.totalResult = totalResult;
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    protected void onDestroy() {
        getArticleUseCase.clearAllDisposable();
        getTotalResultUseCase.clearAllDisposable();
        searchArticleUseCase.clearAllDisposable();
    }
}
