package com.zyq.myapplication.curl;

/**
 * CurlView size changed observer.
 */
public class SizeChangedObserver implements CurlView.SizeChangedObserver {
    CurlView mCurlView;
    public SizeChangedObserver(CurlView _mCurlView){
        this.mCurlView = _mCurlView;
    }

    @Override
    public void onSizeChanged(int w, int h) {
        if (w > h) {
            mCurlView.setViewMode(CurlView.SHOW_TWO_PAGES);
            mCurlView.setMargins(.1f, .05f, .1f, .05f);
        } else {
            mCurlView.setViewMode(CurlView.SHOW_ONE_PAGE);
            mCurlView.setMargins(.1f, .1f, .1f, .1f);
        }
    }
}
