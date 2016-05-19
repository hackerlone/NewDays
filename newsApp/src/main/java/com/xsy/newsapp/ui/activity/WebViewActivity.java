package com.xsy.newsapp.ui.activity;

import com.xsy.newsapp.R;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity{
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_webview);
    	mWebView=(WebView) findViewById(R.id.webview);
    	String url=getIntent().getStringExtra("url");
    	mWebView.loadUrl(url);
    }
}
