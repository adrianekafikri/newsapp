package com.app.adrian.newsapp.di.component;

import android.content.Context;

import com.app.adrian.domain.news.repository.NewsRepository;
import com.app.adrian.newsapp.base.BaseActivity;
import com.app.adrian.newsapp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Adrian Eka Fikri on 8/12/18.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    Context context();

    NewsRepository newsRepository();
}
