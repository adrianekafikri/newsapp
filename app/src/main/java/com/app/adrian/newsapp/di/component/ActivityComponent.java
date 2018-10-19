package com.app.adrian.newsapp.di.component;

import android.app.Activity;

import com.app.adrian.newsapp.di.PerActivity;
import com.app.adrian.newsapp.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
