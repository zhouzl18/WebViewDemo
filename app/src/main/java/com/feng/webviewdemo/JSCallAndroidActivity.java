package com.feng.webviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by OneDay on 2017/5/27.
 *
 * 测试javascript调用Android的方法
 *
 */

public class JSCallAndroidActivity extends AppCompatActivity{
    Context mContext;
    WebView mWebView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_call_android);

        mWebView = (WebView) findViewById(R.id.webView);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JSToAndroid(), "test");
        mWebView.loadUrl("file:///android_asset/testJsCallAnd.html");

    }
}
