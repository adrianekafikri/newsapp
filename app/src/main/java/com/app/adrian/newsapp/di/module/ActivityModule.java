package com.app.adrian.newsapp.di.module;

import android.app.Activity;

import com.app.adrian.newsapp.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian Eka Fikri on 8/12/18.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    Activity providesActivity() {
        return activity;
    }
}
