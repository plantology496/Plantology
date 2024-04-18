package com.example.plantology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlantDetailActivity extends AppCompatActivity {

    FloatingActionButton cameraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        cameraButton = findViewById(R.id.other_cam);
        cameraButton.setOnClickListener(this::openHome);
    }

    private void openHome(View view) {
        Intent intent = new Intent(PlantDetailActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void parseJson(String s){
        try {
            JSONObject jsobj = new JSONObject(s);
            JSONArray jsonArr = jsobj.getJSONArray("data");
            for (int i = 0; i < jsonArr.length(); i++){
                String comname, formalname,year;
                JSONObject jsonobj2 = jsonArr.getJSONObject(i);
                comname = jsonobj2.getString("common_name");
                formalname = jsonobj2.getString("scientific_name");
                year = jsonobj2.getString("year");

               // tv.append("Common name: "+ comname + " Science name: "+ formalname + "Year: " + year + "\n" );

            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }

}