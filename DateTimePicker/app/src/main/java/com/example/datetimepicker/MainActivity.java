package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private TimePicker tp;
/*private TextView tv;*/
    DatePicker dp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*tp =findViewById(R.id.timepicker);*/
       /* tv = findViewById(R.id.textView);*/
        dp = findViewById(R.id.datePicker);

        Calendar calendar =  Calendar.getInstance();
        dp.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                new dp.setOnDateChangedListener(DatePicker dp, int year, int month, int day){}
                );



        /*tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tv.setText("Hour: "+ hourOfDay+"\nMinutes: "+minute);
            }
        });*/

    }
}