package com.example.jsonproject;

import androidx.recyclerview.widget.LinearSmoothScroller;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {
    private String name;
    private String email;
    @SerializedName("sem")
    private int semester;

    private List<Video> mVideo;

    @SerializedName("course")
    private  Course mCourse;


    public Student(String name, String email, int sem, Course course,List<Video> videos) {
        this.name = name;
        this.email = email;
        this.semester = sem;
        mCourse = course;
        mVideo = videos;
    }
}
