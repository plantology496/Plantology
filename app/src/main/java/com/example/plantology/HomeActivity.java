package com.example.plantology;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    // ViewModel
    private HomeViewModel viewModel;

    // UI Components
    private ConstraintLayout cameraButton;

    // For Capturing Photo
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 123;
    private File photoFile;
    public String photoFileName = "photo.jpg";
    private Bitmap takenImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(this::onLaunchCamera);
    }

    // TODO :: Needs to be moved to HomeViewModel (onLaunchCamera, getPhotoFileUri, onActivityResult)
    public void onLaunchCamera(View view) {
        // Create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a File reference for future access
        photoFile = getPhotoFileUri(photoFileName);

        // Wrap File object into a content provider
        // Required for API >= 24
        // See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
        Uri fileProvider = FileProvider.getUriForFile(getApplicationContext(),
                                              "com.codepath.fileprovider",
                                                      photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        // If you call startActivityForResult() using an intent that no app can handle, your app
        // will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    // Returns the File for a photo stored on disk given the fileName
    private File getPhotoFileUri(String fileName) {
        // Get safe storage directory for photos
        // Use `getExternalFilesDir` on Context to access package-specific directories.
        // This way, we don't need to request external read/write runtime permissions.
        File mediaStorageDir = new File(getApplicationContext()
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
            Log.d(TAG, "Failed to create directory");
        }

        // Return the file target for the photo based on filename
        File file = new File(mediaStorageDir.getPath() + File.separator + fileName);

        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK) {
                    // by this point we have the camera photo on disk
                    takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
                    openPlantDetail();
//                    viewModel.runPlantIdentifier(takenImage);
                } else { // Result was a failure
                    Toast.makeText(getApplicationContext(),
                              "Picture wasn't taken!",
                                   Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    // TODO :: Delete
    private void openPlantDetail() {
        Intent intent = new Intent(HomeActivity.this, PlantDetailActivity.class);
        startActivity(intent);
    }
}