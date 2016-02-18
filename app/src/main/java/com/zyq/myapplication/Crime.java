package com.zyq.myapplication;

import java.util.UUID;

/**
 * Created by zangyq on 2016/2/18.
 */
public class Crime {
    private UUID id;



    private String title;
    public Crime(){
        id = UUID.randomUUID();
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
}
