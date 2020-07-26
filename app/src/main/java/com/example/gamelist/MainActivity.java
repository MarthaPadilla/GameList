package com.example.gamelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gamelist.Adapter.RecyclerViewA;
import com.example.gamelist.Modelo.Games;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static String URL = "https://rawg-video-games-database.p.rapidapi.com/games";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;
    private ArrayList<Games> listaGame = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView txt;
    private RecyclerViewA myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
    layout.setOrientation(LinearLayoutManager.VERTICAL);

    ObtenerDato();
    }

    private void ObtenerDato() {

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        StringRequest request =  new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray mArray =  jsonObject.getJSONArray("results");
                    for (int i = 0; i < mArray.length(); i++){

                        JSONObject mjsonObject = mArray.getJSONObject(i);

                        String nombre = mjsonObject.getString("name");
                        String released = mjsonObject.getString("released");
                        String rating = mjsonObject.getString("rating");
                        String slug = mjsonObject.getString("slug");
                        String urlimagen = mjsonObject.getString("background_image");

                        listaGame.add(new Games(nombre, slug, released, rating, urlimagen));
                        //String name, String slug, String released, String rating, String background_image
                    }
                    myAdapter = new RecyclerViewA(MainActivity.this, listaGame);
                    recyclerView.setAdapter(myAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {
            @Override
            public Map<String,String> getHeaders() {
                Map<String, String> customHeaders = new HashMap<>();
                customHeaders.put("x-rapidapi-host", "rawg-video-games-database.p.rapidapi.com");
                customHeaders.put("x-rapidapi-key", "f3e707eb5emsh1c1f2b509e98139p147a3djsnabd158f22092");
                return customHeaders;
            }
        };




        requestQueue.add(request);

    }

}
