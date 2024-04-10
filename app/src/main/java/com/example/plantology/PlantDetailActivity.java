package com.example.plantology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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


}