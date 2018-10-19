package com.app.adrian.newsapp.di.module;

import com.app.adrian.domain.news.interactor.GetSourcesUseCase;
import com.app.adrian.domain.news.repository.NewsRepository;
import com.app.adrian.newsapp.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian Eka Fikri on 8/12/18.
 */
@Module
public class NewsModule {

    @Provides
    @PerActivity
    @Named("getTvSchedule")
    public GetSourcesUseCase getTvScheduleUseCase(NewsRepository newsRepository) {
        return new GetSourcesUseCase(newsRepository);
    }
}
