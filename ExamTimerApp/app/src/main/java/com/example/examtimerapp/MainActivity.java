package com.example.examtimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mnum,done;
    MediaPlayer m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m1 = MediaPlayer.create(this,R.raw.seventh);
        mnum = findViewById(R.id.mnumber);
        done = findViewById(R.id.done);

        new CountDownTimer(6000,1000){

            public  void  onTick(long millisecondsUntilDone){
                mnum.setText("Time: "+String.valueOf(millisecondsUntilDone/1000));

            }

            @Override

            public void onFinish() {
                m1.start();
                done.setText("Done !!!");

            }
        }.start();
    }
}