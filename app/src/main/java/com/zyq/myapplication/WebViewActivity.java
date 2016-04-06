package com.zyq.myapplication;

import android.support.v4.app.Fragment;
import android.widget.ViewFlipper;

/**
 * Created by zangyq on 2016/3/17.
 */
public class WebViewActivity extends SingleFragmentActivity {


    private ViewFlipper flipper;

    @Override
    protected Fragment createFragment() {
        return new WebViewFragment();
    }
}
