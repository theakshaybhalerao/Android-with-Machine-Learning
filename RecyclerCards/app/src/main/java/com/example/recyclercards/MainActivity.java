package com.example.recyclercards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ExampleItem> exampleLists = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button btnAdd,btnDel;
    private EditText etAdd,etDel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.buttonAdd);
        btnDel = findViewById(R.id.buttonDelete);

        etAdd = findViewById(R.id.editTextAdd);
        etDel = findViewById(R.id.editTextDelete);

        generateFakeData();
        recyclerViewConfig();
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etDel.getText().toString().equals("")){
                    etDel.setError("Empty Field");
                }
                else
                {
                    int position = Integer.parseInt(etDel.getText().toString());
                    removeCard(position);
                }


            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etAdd.getText().toString().equals("")){
                    etAdd.setError("Empty Field");
                }
                else
                {
                    int position = Integer.parseInt(etAdd.getText().toString());
                    addCard(position);
                }
            }
        });

    }

    public void addCard(int position){
        exampleLists.add(position,new ExampleItem(R.drawable.one,"New Card added!!"));
        //adapter.notifyDataSetChanged();
        adapter.notifyItemChanged(position);
    }
    public void removeCard(int position){
        exampleLists.remove(position);
        adapter.notifyItemRemoved(position);
    }


    public void generateFakeData()
    {
         exampleLists = new ArrayList<>();

        exampleLists.add(new ExampleItem(R.drawable.one,"Sandy  1"));
        exampleLists.add(new ExampleItem(R.drawable.ten,"AKSHAY @ SULA VINEYARDS 1"));
        exampleLists.add(new ExampleItem(R.drawable.two,"Sandy  2"));
        exampleLists.add(new ExampleItem(R.drawable.twele,"AKSHAY @ SULA VINEYARDS 2"));
        exampleLists.add(new ExampleItem(R.drawable.three,"Sandy  3"));
        exampleLists.add(new ExampleItem(R.drawable.tera,"AKSHAY @ SULA VINEYARDS 3"));
        exampleLists.add(new ExampleItem(R.drawable.four,"Sandy  4"));
        exampleLists.add(new ExampleItem(R.drawable.elevem,"AKSHAY @ SULA VINEYARDS 4"));
    }
    public void recyclerViewConfig(){

        // Config for Recycler View

        recyclerView = findViewById(R.id.recyclerView);

        //Performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleLists);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}