package com.app.adrian.domain.news.interactor;

import com.app.adrian.domain.UseCase;
import com.app.adrian.domain.news.repository.NewsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetTotalResultUseCase extends UseCase<Integer, Void> {

    private NewsRepository newsRepository;

    @Inject
    public GetTotalResultUseCase(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    protected Observable<Integer> buildUseCaseObservable(Void aVoid) {
        return newsRepository.getTotalResult();
    }
}
