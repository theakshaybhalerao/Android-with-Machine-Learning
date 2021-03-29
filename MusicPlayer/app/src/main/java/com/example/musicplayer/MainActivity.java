package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.saathiya);

        // getting Context from Audio Service

        audioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int myMaxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        int myCurrentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //Setting Context to Seek Bar  = Volume Rocker

        SeekBar volumeRocker = findViewById(R.id.volume);
        volumeRocker.setMax(myMaxVol);
        volumeRocker.setProgress(myCurrentVol);

        //set a listner on Volume ROcker

        volumeRocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar timeLine = findViewById(R.id.time);
        timeLine.setMax(mediaPlayer.getDuration());

        // Set On change LIstener on Time Line

        timeLine.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Customise Timeline Seekbar

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLine.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);

    }

    public void playMe(View view){
        mediaPlayer.start();

    }
    public void pauseMe(View view) {
        mediaPlayer.pause();

    }
}