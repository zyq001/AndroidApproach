package com.zyq.myapplication;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zangyq on 2016/2/18.
 * 记录Model类
 */
public class Crime {
    private UUID id;
    private String title;
    private Date mDate;
    private boolean mSloved;
    public Crime(){
        id = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSloved() {
        return mSloved;
    }

    public void setmSloved(boolean mSloved) {
        this.mSloved = mSloved;
    }

    @Override
    public String toString() {
        return title;
    }
}
