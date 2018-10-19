package com.app.adrian.newsapp.news.source;

import com.app.adrian.newsapp.base.BaseContractView;
import com.app.adrian.newsapp.news.model.SourceModel;

import java.util.List;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public interface SourceContract {

    interface View extends BaseContractView {
        void onNewsSourcesLoaded(List<SourceModel> sourceModelList);
    }

    interface Presenter {
        void loadNewsSources();
    }
}
