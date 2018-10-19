package com.app.adrian.newsapp.news.article;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.adrian.newsapp.R;
import com.app.adrian.newsapp.base.BaseRecyclerAdapter;
import com.app.adrian.newsapp.news.model.ArticleModel;
import com.bumptech.glide.Glide;

/**
 * Created by Adrian Eka Fikri on 10/16/18.
 */
public class ArticleRecyclerAdapter extends BaseRecyclerAdapter<ArticleModel> {

    public ArticleRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getHeaderLayout() {
        return 0;
    }

    @Override
    protected int getItemLayout() {
        return R.layout.adapter_article;
    }

    @Override
    protected RecyclerView.ViewHolder createHeaderHolder(View view) {
        return null;
    }

    @Override
    protected RecyclerView.ViewHolder createItemHolder(View view) {
        return new ArticleHolder(view);
    }

    @Override
    protected void processHeaderHolder(RecyclerView.ViewHolder holder) {

    }

    @Override
    protected void processItemHolder(RecyclerView.ViewHolder holder, ArticleModel articleModel,
                                     int position) {
        ArticleHolder articleHolder = (ArticleHolder) holder;

        articleHolder.tvTitle.setText(articleModel.title);
        articleHolder.tvSource.setText(articleModel.source.name);
        Glide.with(context).load(articleModel.urlToImage).into(articleHolder.imageView);
        articleHolder.tvDate.setText(articleModel.publishedAt.substring(0,
                articleModel.publishedAt.lastIndexOf('T')));
    }

    class ArticleHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvSource;
        ImageView imageView;
        TextView tvDate;

        ArticleHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSource = itemView.findViewById(R.id.tvSource);
            imageView = itemView.findViewById(R.id.imageView);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
