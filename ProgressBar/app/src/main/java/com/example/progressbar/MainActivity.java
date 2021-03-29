package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    private Button btnUpload;
    private Button btnStart;
    private  Button btnEnd;
    ProgressBar pb,pbh;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnd = findViewById(R.id.end);
        btnStart = findViewById(R.id.start);
        btnUpload = findViewById(R.id.upload);
        pb = findViewById(R.id.progressBar);
        pbh = findViewById(R.id.progressBarHorizontal);
        pb.setVisibility(View.GONE);


    }
    public void start(View v){
        pb.setVisibility(View.VISIBLE);
    }
    public void upload(View v){
fakeProgress(progress);
    }
    public void end(View v){
        pb.setVisibility(View.GONE);
    }
    public void fakeProgress(int progress){
        pbh.setProgress(progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fakeProgress(progress+10);
            }
        });
        thread.start();
    }
}