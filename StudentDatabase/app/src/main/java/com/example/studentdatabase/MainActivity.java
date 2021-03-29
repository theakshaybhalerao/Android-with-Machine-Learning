package com.example.studentdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText id,name,email,cs;
    Button btnAdd,btnView,btnUpdate,btnDelete,btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        id = findViewById(R.id.editText_id);
        name = findViewById(R.id.editText_name);
        email = findViewById(R.id.editText_email);
        cs = findViewById(R.id.editText_CS);

        btnAdd = findViewById(R.id.button_add);
        btnDelete = findViewById(R.id.button_delete);
        btnUpdate = findViewById(R.id.button_update);
        btnView = findViewById(R.id.button_view);
        btnViewAll = findViewById(R.id.button_viewAll);
        addData();
        getData();

       // showMessage("Test","Testing Done");

    }

    public void addData(){
            btnAdd.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = myDb.insertData(name.getText().toString(),email.getText().toString(),cs.getText().toString());
                    if(isInserted == true) {
                        Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                    }else{

                        Toast.makeText(MainActivity.this,"Something Went Wrong!!",Toast.LENGTH_SHORT).show();
                    }

                }
            });


               /* Toast.makeText(MainActivity.this,"Something Went Wrong!!",Toast.LENGTH_SHORT).show();*/



    }

    public void getData(){
        btnView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etID = findViewById(R.id.editText_id);
                String id = etID.getText().toString();
                if (id.equals(String.valueOf(""))){
                    etID.setError("Enter Id");
                    return;
                }
                Cursor cursor = myDb.getData(id);
                String data = null;

                if(cursor.moveToNext()){
                    data = "ID: "+cursor.getString(0) + "\n"+"NAME: "+cursor.getString(1) + "\n"+"Email: "+cursor.getString(2) + "\n"+"Current Semester "+cursor.getString(3) + "\n";



                }
                showMessage("DATA",data);

            }
        });

    }



    public void showMessage(String title,String msg){
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setMessage(msg);
        builder.show();

    }
}