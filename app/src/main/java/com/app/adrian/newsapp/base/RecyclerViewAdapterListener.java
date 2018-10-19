package com.app.adrian.newsapp.base;

public interface RecyclerViewAdapterListener<T> {

    void onClicked(T item, int position);
    void onLastItem(int size);
}
