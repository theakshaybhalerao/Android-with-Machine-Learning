package com.example.seekbarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity {
    private SeekBar sb;
    TextView tv;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = findViewById(R.id.seekBar);
        tv = findViewById(R.id.textView);
        layout = findViewById(R.id.layout);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText("Value: "+progress);
                tv.setTextSize(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                layout.setBackgroundColor(Color.parseColor("#c1c1c1"));

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}