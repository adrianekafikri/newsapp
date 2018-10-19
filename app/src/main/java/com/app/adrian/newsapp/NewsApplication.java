package com.app.adrian.newsapp;

import android.app.Application;

import com.app.adrian.newsapp.di.component.ApplicationComponent;
import com.app.adrian.newsapp.di.component.DaggerApplicationComponent;
import com.app.adrian.newsapp.di.module.ApplicationModule;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public class NewsApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();
    }

    private void initInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
