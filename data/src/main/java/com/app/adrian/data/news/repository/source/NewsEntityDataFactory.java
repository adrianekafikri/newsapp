package com.app.adrian.data.news.repository.source;

import com.app.adrian.data.AbstractEntityDataFactory;
import com.app.adrian.data.news.repository.source.network.NetworkNewsEntityData;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
@Singleton
public class NewsEntityDataFactory extends AbstractEntityDataFactory<NewsEntityData> {

    @Inject
    public NewsEntityDataFactory() {

    }

    @Override
    public NewsEntityData createData() {
        return new NetworkNewsEntityData();
    }
}
