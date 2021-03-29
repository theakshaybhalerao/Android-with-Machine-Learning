package com.example.jsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new Gson();
       /* Student stud = new Student("AKSHAY","akshay@gmail.com",2);
        String json = gson.toJson(stud);*/

       /* String json = "{\"email\":\"akshay@gmail.com\",\"name\":\"AKSHAY\",\"sem\":2}";
        Student student = gson.fromJson(json,Student.class);


        Log.d("TEST",student.toString());*/
        /*Toast.makeText(getApplicationContext(),json,Toast.LENGTH_LONG).show();


*/

        List<Video> Videos = new ArrayList<>();
        Videos.add(new Video("First Video",5));
        Videos.add(new Video("Second Video",6));
        Videos.add(new Video("Third Video",33));
        Videos.add(new Video("Fourth Video",855));
        Videos.add(new Video("Fifth Video",4646));


       /* Course course = new Course("Java","Bootcamp","akshay@gmail.com");
        Student student = new Student("AKSHAY","AKSHAY@gmail.com",3,course,Videos);
        String json = gson.toJson(student);

        Log.d("TEST ",json);*/

        String json = "{\"email\":\"AKSHAY@gmail.com\",\"course\":{\"description\":\"Bootcamp\",\"email\":\"akshay@gmail.com\",\"name\":\"Java\"},\"mVideo\":[{\"Duration\":5,\"name\":\"First Video\"},{\"Duration\":6,\"name\":\"Second Video\"},{\"Duration\":33,\"name\":\"Third Video\"},{\"Duration\":855,\"name\":\"Fourth Video\"},{\"Duration\":4646,\"name\":\"Fifth Video\"}],\"name\":\"AKSHAY\",\"sem\":3}";
        Student student = gson.fromJson(json,Student.class);

        Log.d("TEST ",student.toString());

/*
        String json = "{\"email\":\"AKSHAY@gmail.com\",\"course\":{\"description\":\"Bootcamp\",\"email\":\"akshay@gmail.com\",\"name\":\"Java\"},\"name\":\"AKSHAY\",\"sem\":3}";
        Student student = gson.fromJson(json,Student.class);

        Log.d("TEST ",student.toString());*/

    }
}