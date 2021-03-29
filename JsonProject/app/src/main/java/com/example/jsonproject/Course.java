package com.example.jsonproject;

import androidx.dynamicanimation.animation.SpringForce;

import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("name")
    private String mName;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("email")
    private String mEmail;




    public Course(String mName, String mDescription,String mEmail) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mEmail = mEmail;
    }
}
