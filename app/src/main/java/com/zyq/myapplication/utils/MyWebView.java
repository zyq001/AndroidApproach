package com.zyq.myapplication.utils;

/**
 * Created by zangyq on 2016/4/6.
 */
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.zyq.myapplication.R;

public class MyWebView extends WebView {
    float downXValue;
    long downTime;
    private ViewFlipper flipper;
    private float lastTouchX, lastTouchY;
    private boolean hasMoved = false;
    public MyWebView(Context context, ViewFlipper flipper) {
        super(context);
        this.flipper = flipper;
    }
    @Override
    public boolean onTouchEvent(MotionEvent evt) {
        boolean consumed = super.onTouchEvent(evt);
        if (isClickable()) {
            switch (evt.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    lastTouchX = evt.getX();
                    lastTouchY = evt.getY();
                    downXValue = evt.getX();
                    downTime = evt.getEventTime();
                    hasMoved = false;
                    break;
                case MotionEvent.ACTION_MOVE:
                    hasMoved = moved(evt);
                    break;
                case MotionEvent.ACTION_UP:
                    float currentX = evt.getX();
                    long currentTime = evt.getEventTime();
                    float difference = Math.abs(downXValue - currentX);
                    long time = currentTime - downTime;
                    Log.i("Touch Event========", "Distance: " + difference
                            + "px Time: " + time + "ms");
                    if ((downXValue < currentX)
                            && (difference > 100 && (time < 220))) {
                        /** 跳到上一页 */
//                        this.flipper.setInAnimation(AnimationUtils.loadAnimation(
//                                this.getContext(), R.anim.push_right_in));
//                        this.flipper.setOutAnimation(AnimationUtils.loadAnimation(
//                                this.getContext(), R.anim.push_right_out));
                        flipper.showPrevious();
                    }
                    /** X轴滑动间隔大于100，并且时候小于220ms，并且向X轴左标的目标滑动 */
                    if ((downXValue > currentX) && (difference > 100)
                            && (time < 220)) {
                        /** 跳到下一页 */
//                        this.flipper.setInAnimation(AnimationUtils.loadAnimation(
//                                this.getContext(), R.anim.push_left_in));
//                        this.flipper.setOutAnimation(AnimationUtils.loadAnimation(
//                                this.getContext(), R.anim.push_left_out));
                        flipper.showNext();
                    }
                    break;
            }
        }
        return consumed || isClickable();
    }
    private boolean moved(MotionEvent evt) {
        return hasMoved || Math.abs(evt.getX() - lastTouchX) > 10.0
                || Math.abs(evt.getY() - lastTouchY) > 10.0;
    }
}
