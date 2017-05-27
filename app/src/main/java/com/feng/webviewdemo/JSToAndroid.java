package com.feng.webviewdemo;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by OneDay on 2017/5/27.
 *
 * JS调用Android的类
 *
 */

public class JSToAndroid extends Object {
    private static final String TAG = "JSToAndroid";

    @JavascriptInterface
    public void hello(String s){
        Log.i(TAG, "hello: " + s);
    }
}
