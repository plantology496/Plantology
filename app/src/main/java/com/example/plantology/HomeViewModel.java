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

    // parameter: Bitmap takenImage
   public void runPlantIdentifier() {
        openPlantDetail("sunflower");
//      try {
//    Model model = Model.newInstance(context);
//
//    // Creates inputs for reference.
//    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 180, 180, 3}, DataType.FLOAT32);
//    inputFeature0.loadBuffer(byteBuffer);
//
//    // Runs model inference and gets result.
//    Model.Outputs outputs = model.process(inputFeature0);
//    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
//
//    // Releases model resources if no longer used.
//    model.close();
//} catch (IOException e) {
//    // TODO Handle the exception
//}

//
   }
    private void openPlantDetail(String plantName) {
        Intent intent = new Intent(context, PlantDetailActivity.class);
        intent.putExtra("plantName",plantName);
        context.startActivity(intent);
    }
}
