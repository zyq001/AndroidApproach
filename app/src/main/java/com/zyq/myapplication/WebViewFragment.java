package com.zyq.myapplication;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.zyq.myapplication.utils.MyWebView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewFlipper flipper;
    MyWebView myWebView;

    public WebViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebViewFragment newInstance(String param1, String param2) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        flipper = (ViewFlipper) getActivity().findViewById(R.id.ViewFlipper);

        flipper.setFlipInterval(1000);
        //添加第一个alipper 为 http://www.baidu.com
        flipper.addView(addWebView("http://www.baidu.com"));
        //添加第二个alipper 为 http://www.google.com.hk
        flipper.addView(addWebView("http://www.google.com.hk"));

    }

    /**
     * 往flipper中添加WebView
     * @param url 网页地址
     * @return
     */
    private View addWebView(String url){
        myWebView = new MyWebView(getActivity(), flipper);
        //设置WebView属性，能够执行Javascript脚本
        myWebView.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        //webview.loadUrl("file:///android_asset/index.html");
        myWebView.loadUrl(url);

        //使WebView的网页跳转在WebView中进行，而非跳到浏览器
        myWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        return myWebView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_webview, container, false);
//        WebView wv = (WebView) v.findViewById(R.id.webView);
//        wv.getSettings().setJavaScriptEnabled(true);
////        wv.loadUrl("http://yiduserver.youdao.com/dc.s?id=3026125");
//        wv.loadUrl("http://stackoverflow.com/");
//        if (Build.VERSION.SDK_INT >= 19) {
//            Toast.makeText(getActivity(), "hhahhhhaha", Toast.LENGTH_LONG).show();
//            wv.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//
//        }
//        return v;
//    }

}
