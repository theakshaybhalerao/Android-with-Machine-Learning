package com.example.currencyconverterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {
    private Button pound,euro,dollar,dhiram,yen,bitcoin,russian,swiss,phillip;
    private EditText et;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
        tv = findViewById(R.id.textView);
        pound = findViewById(R.id.pounds);
        euro = findViewById(R.id.euros);
        dollar = findViewById(R.id.dollar);
        dhiram = findViewById(R.id.dhiram);
        yen = findViewById(R.id.yen);
        bitcoin = findViewById(R.id.bitcoin);
        russian = findViewById(R.id.russian);
        swiss = findViewById(R.id.Swiss_franc);
        phillip = findViewById(R.id.philippine);

        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = et.getText().toString();

                if (TextUtils.isEmpty(z)){
                    et.setError("Empty User Input");
                }else{
                    double n,k;
                    n = Double.parseDouble(z);
                    tv.setText(null);
                    Formatter formatter = new Formatter();
                    k = n*87.83;
                    DecimalFormat nf = new DecimalFormat("#.00");
                    tv.setText(""+nf.format(k));
                }
            }
        });


    }
}