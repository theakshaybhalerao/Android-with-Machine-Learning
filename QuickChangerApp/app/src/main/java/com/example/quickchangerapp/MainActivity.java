package com.example.quickchangerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout layout;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout= findViewById(R.id.layout);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.black:
                        layout.setBackgroundColor(Color.parseColor("#242B2E"));
                        break;
                    case R.id.green:
                        layout.setBackgroundColor(Color.parseColor("#3DBE29"));
                        break;
                    case R.id.yellow:
                        layout.setBackgroundColor(Color.parseColor("#F7CD2E"));
                        break;
                    case R.id.pink:
                        layout.setBackgroundColor(Color.parseColor("#E03B8B"));
                        break;
                    case R.id.white:
                        layout.setBackgroundColor(Color.parseColor("#CAD5E2"));
                        break;

                }
            }
        });
    }
}