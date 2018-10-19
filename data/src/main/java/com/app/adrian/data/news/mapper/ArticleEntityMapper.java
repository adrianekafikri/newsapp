package com.app.adrian.data.news.mapper;
import com.app.adrian.data.news.ArticleEntity;
import com.app.adrian.domain.news.Article;
import com.app.adrian.domain.news.Source;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ArticleEntityMapper {

    @Inject
    public ArticleEntityMapper() {

    }

    public List<Article> transform(List<ArticleEntity> articleEntities) {
        ArrayList<Article> articles = new ArrayList<>();

        if (articleEntities != null && !articleEntities.isEmpty()) {
            for (ArticleEntity entity : articleEntities) {
                Article article = new Article();

                Source source = new Source();
                source.id = entity.source.id;
                source.name = entity.source.name;

                article.source = source;
                article.author = entity.author;
                article.title = entity.title;
                article.description = entity.description;
                article.url = entity.url;
                article.urlToImage = entity.urlToImage;
                article.publishedAt = entity.publishedAt;

                articles.add(article);
            }
        }

        return articles;
    }
}
