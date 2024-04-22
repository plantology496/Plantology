package com.example.plantology;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;


import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.lifecycle.AndroidViewModel;



import com.example.plantology.ml.FlowerMl;




import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private static final String TAG = "HomeViewModel";

    private final Context context;


    public HomeViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
   //private ImageLabeler imageLabeler;

   public void runPlantIdentifier(Bitmap takenImage) {
        openPlantDetail("sunflower");

//    try {
//        FlowerMl model = FlowerMl.newInstance(context);
//
//        // Creates inputs for reference.
//        TensorImage image = TensorImage.fromBitmap(takenImage);
//
//        // Runs model inference and gets result.
//        FlowerMl.Outputs outputs = model.process(image);
//        List<Category> probability = outputs.getProbabilityAsCategoryList();
//
//        openPlantDetail(probability.get(0).toString());
//        // Releases model resources if no longer used.
//        model.close();
//    } catch (IOException e) {
//        // TODO Handle the exception

//    }
//
   }
    private void openPlantDetail(String plantName) {
        Intent intent = new Intent(context, PlantDetailActivity.class);
        intent.putExtra("plantName",plantName);
        context.startActivity(intent);
    }
}
