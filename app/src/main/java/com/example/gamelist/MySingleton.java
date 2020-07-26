package com.example.gamelist;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MySingleton {
 private static MySingleton instancia;
 private RequestQueue requestQueue;
 private ImageLoader imageLoader;
 private static Context con;


 private MySingleton(Context context){
     con =context;
     requestQueue= getRequestQueue();

     imageLoader = new ImageLoader(requestQueue,
             new ImageLoader.ImageCache() {
                 @Override
                 public Bitmap getBitmap(String url) {
                     return null;
                 }

                 @Override
                 public void putBitmap(String url, Bitmap bitmap) {

                 }
             });

 }

 public static synchronized MySingleton getInstance(Context context){
     if (instancia == null){
         instancia= new MySingleton(context);
     }
     return instancia;
 }

 public  RequestQueue getRequestQueue(){

     if (requestQueue==null){
         requestQueue= Volley.newRequestQueue(con.getApplicationContext());
     }
     return requestQueue;
 }

 public <T> void addToRequestQueue(Request<T> req){
     getRequestQueue().add(req);
 }
 public  ImageLoader getImageLoader(){
     return imageLoader;
 }
}
