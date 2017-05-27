package com.feng.webviewdemo;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class AndroidCallJSActivity extends AppCompatActivity implements View.OnClickListener{
    Context mContext;
    WebView mWebView;
    Button mBtnJS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_js);

        mContext = this;

        mWebView = (WebView) findViewById(R.id.webView);
        mBtnJS = (Button) findViewById(R.id.btn_call_js);
        mBtnJS.setOnClickListener(this);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        mWebView.loadUrl("file:///android_asset/testAndCallJS.html");

        /*mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle(android.R.string.cancel).
                        setMessage(message).
                        setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                builder.setCancelable(false);
                builder.create().show();
                return true;
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_call_js:
                mWebView.post(new Runnable() {
                    @Override
                    public void run() {
                        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
                            mWebView.loadUrl("javascript:callJS()");
                        }else{
                            mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                                @Override
                                public void onReceiveValue(String value) {
                                    Toast.makeText(mContext, "value = " + value, Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
                break;
        }
    }
}
