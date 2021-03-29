package com.example.apihandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button button;
    private RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = findViewById(R.id.textView);
        button = findViewById(R.id.magic);

        /*requestQueue = Volley.newRequestQueue(this);*/

        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAPIRequest();
            }
        });
    }
    private void sendAPIRequest(){
        String url = "https://sleepy-cliffs-19222.herokuapp.com/0n4MT7BO3.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("students");
                    for (int i =0;i<jsonArray.length();i++){
                        JSONObject student = jsonArray.getJSONObject(i);
                        String name = student.getString("name");
                        int course_count = student.getInt("course_count");
                        String email = student.getString("email");
                        tv.append(name+" , "+course_count+" , "+email+"\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //popup window
                Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);

    }

}