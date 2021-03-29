package com.example.burgerratingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
RatingBar rb;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb=findViewById(R.id.ratingBar);
        tv= findViewById(R.id.textView);

    }
    public void submit(View v){
        float ratingValue = rb.getRating();
        if(ratingValue <2){
            tv.setText("Rating"+ratingValue+"\n We will try better");

        }else if(ratingValue <=3 && ratingValue >= 2){
            tv.setText("Rating"+ratingValue+"\n We should improve");

        }

    }
}