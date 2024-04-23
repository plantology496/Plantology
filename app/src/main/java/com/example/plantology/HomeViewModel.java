package com.example.plantology;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.lifecycle.AndroidViewModel;


import com.example.plantology.ml.Model;
import com.example.plantology.ml.ModelFlowers1;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private static final String TAG = "HomeViewModel";

    private final Context context;


    public HomeViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
   public void runPlantIdentifier(Bitmap takenImage) {
//       try {
//           ModelFlowers1 model = ModelFlowers1.newInstance(context);
//
//           // Creates inputs for reference.
//           TensorImage image = TensorImage.fromBitmap(takenImage);
//
//           // Runs model inference and gets result.
//           ModelFlowers1.Outputs outputs = model.process(image);
//           List<Category> probability = outputs.getProbabilityAsCategoryList();
//
//           // Releases model resources if no longer used.
//           model.close();
//           String plantFound = "";
//           float max = 0;
//           for (int j = 0; j < probability.size(); j++){
//               float percent = probability.get(j).getScore()*100;
//               if (max < percent ){
//                   max = percent;
//                   plantFound = probability.get(j).getLabel();
//                //   Log.i(TAG, "runPlantIdentifier: "+percent+ " "+ max+ " "+  j + " " + plantFound);
//               }
//           }
//           //openPlantDetail(plantFound);
//           Log.i(TAG, "runPlantIdentifier: " + plantFound);
////          //  get label gives name for plant, get scorce tell percent
////           Log.i(TAG, "runPlantIdentifier index 0:" + probability.get(0).toString());
////           Log.i(TAG, "runPlantIdentifier index 1:" + probability.get(1).toString());
////           Log.i(TAG, "runPlantIdentifier index 2:" + probability.get(2).toString());
////           Log.i(TAG, "runPlantIdentifier index 3:" + probability.get(3).toString());
////           Log.i(TAG, "runPlantIdentifier index 4:" + probability.get(4).toString());
//       } catch (IOException e) {
//           // TODO Handle the exception
//       }

   }
    private void openPlantDetail(String plantName) {
        Intent intent = new Intent(context, PlantDetailActivity.class);
        intent.putExtra("plantName",plantName);
        context.startActivity(intent);
    }
}
