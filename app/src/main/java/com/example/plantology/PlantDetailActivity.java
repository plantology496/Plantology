package com.example.plantology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
//        String plantName = getIntent().getStringExtra("plantName");
//        getPlantInfo(plantName);
        //getPlantInfo("aloe vera");
        setContentView(R.layout.activity_plant_detail);
        cameraButton = findViewById(R.id.other_cam);
        cameraButton.setOnClickListener(this::openHome);
    }

    private void openHome(View view) {
        Intent intent = new Intent(PlantDetailActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void fetchSun(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://trefle.io/api/v1/plants/search?token=rZ-7R4Cf8JDByn0SZer2AXIOxyS3yXyY53XtEtq56RY&q=wetlandsunflower";
          TextView plant_name = findViewById(R.id.plant_name);
          TextView plant_desc = findViewById(R.id.desc_text);
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Picasso.get()
                                .load("https://bs.plantnet.org/image/o/716addb37cf8883bffe882d8e729f559291269a1")
                                .resize(1000,1000)
                                .into((android.widget.ImageView) findViewById(R.id.plant_image));
                        parseJson(s);
                        sundesc();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                plant_name.setText("That didnt work");
            }
        });
        queue.add(sr);
    }
    public void fetchTul(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://trefle.io/api/v1/plants/search?token=rZ-7R4Cf8JDByn0SZer2AXIOxyS3yXyY53XtEtq56RY&q=wildtulip";
            TextView plant_name = findViewById(R.id.plant_name);
             TextView plant_desc = findViewById(R.id.desc_text);
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Picasso.get()
                                .load("https://bs.plantnet.org/image/o/d4c0f2783bc219e8f87613b802537bc8b48900ff")
                                .resize(1000,1000)
                                .into((android.widget.ImageView) findViewById(R.id.plant_image));
                        tulipdesc();
                        parseJson(s);
                       tulipdesc();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                plant_name.setText("That didnt work");
            }
        });
        queue.add(sr);
    }
    public void fetchAl(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://trefle.io/api/v1/plants/search?token=rZ-7R4Cf8JDByn0SZer2AXIOxyS3yXyY53XtEtq56RY&q=fynbosaleo";
          TextView plant_name = findViewById(R.id.plant_name);
    TextView plant_desc = findViewById(R.id.desc_text);
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Picasso.get()
                                .load("https://bs.plantnet.org/image/o/a63d11c6686000784667f0196717660e7cbf2701")
                                .resize(1000,1000)
                                .into((android.widget.ImageView) findViewById(R.id.plant_image));
                        parseJson(s);
                        aloedesc();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                plant_name.setText("That didnt work");
            }
        });
        queue.add(sr);
    }
    public void parseJson(String s){
        TextView plant_name = findViewById(R.id.plant_name);
        TextView plant_desc = findViewById(R.id.desc_text);
        String comname, formalname,year;
        try {
            JSONObject jsobj = new JSONObject(s);
            JSONArray jsonArr = jsobj.getJSONArray("data");
            for (int i = 0; i < jsonArr.length(); i++){

                JSONObject jsonobj2 = jsonArr.getJSONObject(i);
                comname = jsonobj2.getString("common_name");
                formalname = jsonobj2.getString("scientific_name");
                year = jsonobj2.getString("year");

                plant_name.setText(comname);
                plant_desc.setText("The plants scientific name is : " + formalname + "\n and was discovered in:  " + year+ "\n");

            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

   }
    public void tulipdesc() {
        TextView plant_desc = findViewById(R.id.desc_text);
            plant_desc.append("\nTulipa orphanidea, a bulbous perennial, stands at a height of 10 to 20 cm. Its stem, either smooth or hairy, supports 2 to 7 green leaves, often tinged with red along their edges. Atop the stem, 1 to 4 globular to star-shaped flowers bloom, boasting copper-red tepals," +
                    " occasionally with hints of yellow, arranged in two whorls of three.\n \n");
            plant_desc.append("\nNative to the southeast Balkans, Bulgaria, Greece, Aegean Islands, Crete, and western Turkey, Tulipa orphanidea thrives in habitats ranging from black pine forests to fields and roadsides, reaching altitudes of up to 1,700 m. Since 1861," +
                    " it has been cherished as an ornamental garden adornment.");
    }
    public void sundesc() {
        TextView plant_desc = findViewById(R.id.desc_text);
        plant_desc.append("\nHelianthus heterophyllus, also known as variableleaf sunflower or wetland sunflower, graces the coastal plain of the southern United States, spanning from Texas to North Carolina. This perennial, reaching heights of up to 120 cm, spreads via underground rhizomes.\n \n");
        plant_desc.append("\nIts hairless or nearly hairless leaves and stems exhibit a white underside due to abundant wax. Each plant may bear 1 to 5 flower heads, featuring 12 to 18 yellow ray florets encircling at least 100 red or brown disc florets. Thriving in wet sandy soils at low elevations, this species adds vibrancy to its surroundings.");
    }
    public void aloedesc() {
        TextView plant_desc = findViewById(R.id.desc_text);
        plant_desc.append("\n In Peninsula Sandstone Fynbos vegetation, Aloe succotrina thrives, often nestled high on cliff faces and rocky outcrops, safe from seasonal fires. Forming clusters up to 1 to 2 meters in diameter, this aloe's dense rosettes come to life in winter (June to September), showcasing tall racemes adorned with shiny red flowers, eagerly visited by sunbirds for pollination. \n");
        plant_desc.append("\nPreferring sunny, well-drained spots, it requires ample space to flourish, eventually developing into expansive, dense clusters. Propagation is achievable through both cuttings/offshoots and seeds.");
    }

    public void getPlantInfo(String s){
        switch (s){
            case "tulip":
                fetchTul();
                break;
            case "Tulip":
                fetchTul();
                break;
            case  "sunflower" :
                fetchSun();
                break;
            case "Sunflower":
                fetchSun();
                break;
            case  "aloe vera":
            fetchAl();
            break;

        }
    }

}