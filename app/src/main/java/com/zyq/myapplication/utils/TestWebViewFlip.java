package com.zyq.myapplication.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ViewFlipper;

import com.zyq.myapplication.R;
import com.zyq.myapplication.curl.CurlView;
import com.zyq.myapplication.curl.PageProvider;
import com.zyq.myapplication.curl.SizeChangedObserver;

/**
 * Created by zangyq on 2016/4/6.
 */
public class TestWebViewFlip extends Activity {

    private ViewFlipper flipper;

    //定义类myWebView
    //MyWebView类，重写了onTouchEvent方法
    WebView myWebView;
//    MyWebView myWebView;
    private CurlView mCurlView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        flipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper);
//
//        //添加第一个alipper 为 http://www.baidu.com
//        flipper.addView(addWebView("http://www.baidu.com"));
//        //添加第二个alipper 为 http://www.google.com.hk
//        flipper.addView(addWebView("http://www.google.com.hk"));

        mCurlView = (CurlView) findViewById(R.id.curl);
        mCurlView.addView(addWebView("http://www.google.com.hk"));
        mCurlView.addView(addWebView("http://www.baidu.com"));
        mCurlView.getUrls().add("http://www.google.com.hk");
        mCurlView.getUrls().add("http://www.baidu.com");

        mCurlView.setPageProvider(new PageProvider(this.mCurlView));
        mCurlView.setSizeChangedObserver(new SizeChangedObserver(this.mCurlView));
        mCurlView.setCurrentIndex(0);
//        mCurlView.setBackgroundColor(0xFF202830);


    }

    @Override
    public void onPause() {
        super.onPause();
        mCurlView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mCurlView.onResume();
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        return mCurlView.getCurrentIndex();
    }

    /**
     * 往flipper中添加WebView
     * @param url 网页地址
     * @return
     */
    private View addWebView(String url){
        myWebView = new WebView(this);
//        myWebView = new MyWebView(this, flipper);
        //设置WebView属性，能够执行Javascript脚本
        myWebView.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        //webview.loadUrl("file:///android_asset/index.html");
        myWebView.loadUrl(url);

        //使WebView的网页跳转在WebView中进行，而非跳到浏览器
        myWebView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        return myWebView;
    }
}
