package com.app.adrian.data.news;

import com.app.adrian.data.BaseResponse;

import java.util.List;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public class NewsResponse extends BaseResponse {

    public List<SourceEntity> sources;

    public int totalResults;

    public List<ArticleEntity> articles;
}
