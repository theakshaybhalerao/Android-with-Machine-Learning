package com.example.jsonproject;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("name")
    private String mName;
    @SerializedName("Duration")
    private int mDuration;

    public Video(String mName, int mDuration) {
        this.mName = mName;
        this.mDuration = mDuration;
    }
}
