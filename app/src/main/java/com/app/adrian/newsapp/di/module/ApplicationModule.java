package com.app.adrian.newsapp.di.module;

import android.content.Context;

import com.app.adrian.data.news.repository.NewsEntityRepository;
import com.app.adrian.domain.news.repository.NewsRepository;
import com.app.adrian.newsapp.NewsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian Eka Fikri on 8/12/18.
 */
@Module
public class ApplicationModule {

    private final NewsApplication application;

    public ApplicationModule(NewsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context providesApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    NewsRepository providesNewsRepository(NewsEntityRepository newsEntityRepository) {
        return newsEntityRepository;
    }
}
