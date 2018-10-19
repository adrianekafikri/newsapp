package com.app.adrian.newsapp.di.component;

import com.app.adrian.newsapp.news.article.ArticleActivity;
import com.app.adrian.newsapp.news.source.SourceActivity;
import com.app.adrian.newsapp.di.PerActivity;
import com.app.adrian.newsapp.di.module.ActivityModule;
import com.app.adrian.newsapp.di.module.NewsModule;

import dagger.Component;

/**
 * Created by Adrian Eka Fikri on 8/12/18.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, NewsModule.class})
public interface NewsComponent {

    void inject(SourceActivity sourceActivity);
    void inject(ArticleActivity articleActivity);
}
