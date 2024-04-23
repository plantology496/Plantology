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
        //String plantName = getIntent().getStringExtra("plantName");
        //getPlantInfo(plantName);
        getPlantInfo("sunflower");
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
        String url = "https://trefle.io/api/v1/plants/search?token=rZ-7R4Cf8JDByn0SZer2AXIOxyS3yXyY53XtEtq56RY&q=sunflower";
        TextView plant_name = findViewById(R.id.plant_name);
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        parseJsonSun(s);
                        sundesc();
                        Picasso.get()
                                .load("https://bs.plantnet.org/image/o/e92bdbc5adc4e91cc0c5aa8e9f102833a28bc6e3")
                                .resize(1000,1000)
                                .into((android.widget.ImageView) findViewById(R.id.plant_image));
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
    public void fetchRose(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://trefle.io/api/v1/plants/search?token=rZ-7R4Cf8JDByn0SZer2AXIOxyS3yXyY53XtEtq56RY&q=aplinerose";
        TextView plant_name = findViewById(R.id.plant_name);
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Picasso.get()
                                .load("https://bs.plantnet.org/image/o/7097f02868c5809ba4f42fdf6a3d498133973157")
                                .resize(1000,1000)
                                .into((android.widget.ImageView) findViewById(R.id.plant_image));
                        parseJson(s);
                        rosedesc();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                plant_name.setText("That didnt work");
            }
        });
        queue.add(sr);
    }
    public void fetchDan(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://trefle.io/api/v1/plants/search?token=rZ-7R4Cf8JDByn0SZer2AXIOxyS3yXyY53XtEtq56RY&q=dandelion";
          TextView plant_name = findViewById(R.id.plant_name);
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Picasso.get()
                                .load("https://bs.plantnet.org/image/o/0db7ea62d6284a8e474472a660e6af4fa2d6ac7f")
                                .resize(1000,1000)
                                .into((android.widget.ImageView) findViewById(R.id.plant_image));
                        parseJson(s);
                        dandesc();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                plant_name.setText("That didnt work");
            }
        });
        queue.add(sr);
    }
    public void fetchDas(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://trefle.io/api/v1/plants/search?token=rZ-7R4Cf8JDByn0SZer2AXIOxyS3yXyY53XtEtq56RY&q=daisy";
        TextView plant_name = findViewById(R.id.plant_name);
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Picasso.get()
                                .load("https://bs.plantnet.org/image/o/43061c6c2cb49908503eac2eaec0ddab69958e17")
                                .resize(1000,1000)
                                .into((android.widget.ImageView) findViewById(R.id.plant_image));
                        parseJsonSun(s);
                        dasdesc();
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
    public void parseJsonSun(String s){
        TextView plant_name = findViewById(R.id.plant_name);
        TextView plant_desc = findViewById(R.id.desc_text);
        String comname, formalname,year;
        try {
            JSONObject jsobj = new JSONObject(s);
            JSONArray jsonArr = jsobj.getJSONArray("data");
                JSONObject jsonobj2 = jsonArr.getJSONObject(0);
                comname = jsonobj2.getString("common_name");
                formalname = jsonobj2.getString("scientific_name");
                year = jsonobj2.getString("year");
                plant_name.setText(comname);
                plant_desc.setText("The plants scientific name is : " + formalname + "\n and was discovered in:  " + year+ "\n");

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
        plant_desc.append("\n The common sunflower (Helianthus annuus) is a species of large annual forb of the daisy family Asteraceae. The common sunflower is harvested for its edible oily seeds which are used in the production of cooking oil.\n \n");
        plant_desc.append("\nThe Helianthus annuus is known for its multiple flower heads, whereas the domestic sunflower often possesses a single large flower head atop an unbranched stem.");
    }
    public void dandesc() {
        TextView plant_desc = findViewById(R.id.desc_text);
        plant_desc.append("\n They are annual or perennial herbs growing from a fibrous root system or a taproot. One species has rhizomes with tubers. The plants produce a single stem or up to 50 or more, usually growing erect, reaching a few centimeters to 75 centimeters tall. \n");
        plant_desc.append("\n The blades are often linear to lance-shaped, toothed or lobed, and borne on winged petioles. The flower heads are solitary, growing at the top of the stem or on stalks from the leaf axils. They contain up to 60 yellow or orange flowers.");
    }
    public void dasdesc() {
        TextView plant_desc = findViewById(R.id.desc_text);
        plant_desc.append("\n Bellis perennis is a perennial herbaceous plant growing to 20 centimetres (8 inches) in height.[4] It has short creeping rhizomes and rosettes of small rounded or spoon-shaped leaves that are from 2 to 5 cm (3⁄4–2 in) long and grow flat to the ground. \n");
        plant_desc.append("\nThe species habitually colonises lawns, and is difficult to eradicate by mowing, hence the term 'lawn daisy'. It blooms from March to September[4] and exhibits the phenomenon of heliotropism, in which the flowers follow the position of the sun in the sky.\n" +
                "\n");
    }

    public void rosedesc() {
        TextView plant_desc = findViewById(R.id.desc_text);
        plant_desc.append("\nRosa pendulina, (syn. Rosa alpina), the Alpine rose or mountain rose, is a species of wild rose found in the mountains of central and southern Europe. It appears to have survived in glacial refugia in the Alps and Carpathians, and spread out from there.[4] A climbing shrub with deep pink flowers and relatively few thorns, it has had a history of cultivation as an ornamental plant\n");
    }
    public void getPlantInfo(String s){
        switch (s){
            case "tulip":
                fetchTul();
                break;
            case "daisy":
                fetchDas();
                break;
            case  "sunflower" :
                fetchSun();
                break;
            case "dandelion":
                fetchDan();
                break;
            case  "rose":
                fetchRose();
            break;

        }
    }


}