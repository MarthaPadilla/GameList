package com.example.gamelist.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewA {
    private Context mCon;
    private ArrayList<Games> lsitaGame;

    public RecyclerViewA(Context mCon, ArrayList<Games> listagame){
        this.mCon=mCon;
        this.lsitaGame=listagame;
    }

}
