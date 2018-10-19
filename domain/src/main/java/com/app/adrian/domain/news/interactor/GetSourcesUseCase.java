package com.app.adrian.domain.news.interactor;

import com.app.adrian.domain.UseCase;
import com.app.adrian.domain.news.Source;
import com.app.adrian.domain.news.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public class GetSourcesUseCase extends UseCase<List<Source>, Void> {

    private NewsRepository newsRepository;

    @Inject
    public GetSourcesUseCase(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    protected Observable<List<Source>> buildUseCaseObservable(Void aVoid) {
        return newsRepository.getSources();
    }
}
