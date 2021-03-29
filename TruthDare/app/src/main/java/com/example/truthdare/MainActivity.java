package com.example.truthdare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageView iv;
    private Random rn = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        iv = findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin(v);
            }
        });

    }
    public void spin(View view){
        int newDirection = rn.nextInt(3600);
        float pivotX = iv.getWidth()/2;
        float pivotY = iv.getHeight()/2;

        Animation rotate = new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);
        rotate.setDuration(6000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                btn.setEnabled(false);
              //  btn.setBackgroundColor(Color.parseColor("#CC3232"));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            btn.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection = newDirection;
        iv.startAnimation(rotate);

    }
}