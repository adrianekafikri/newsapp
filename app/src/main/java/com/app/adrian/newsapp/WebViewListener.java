package com.app.adrian.newsapp;

public interface WebViewListener {

    void onPageStarted(String url);
    void onPageFinished();
    void onProgressChanged(int progress);
}
