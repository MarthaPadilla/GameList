package com.example.gamelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.gamelist.Adapter.RecyclerViewA;
import com.example.gamelist.Modelo.Games;

import java.util.ArrayList;

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
    }
}
