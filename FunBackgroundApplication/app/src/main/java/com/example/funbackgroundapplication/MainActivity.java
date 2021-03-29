package com.example.funbackgroundapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private ImageButton imageButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.bglayout);
        imageButton1 = findViewById(R.id.imageButton);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rn = new Random();

                int color = Color.argb(255,rn.nextInt(256),rn.nextInt(256),rn.nextInt(256));
                layout.setBackgroundColor(color);

            }
        });
    }
}