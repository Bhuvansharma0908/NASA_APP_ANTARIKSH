package com.example.nasaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class RocketLaunch extends AppCompatActivity {

    WebView webRocketView;
    TextView txtLaunchDate, txtPartners, txtObjective;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_launch);

        // Initializing the web view content
        webRocketView = findViewById(R.id.webRocketView);
        webRocketView.loadUrl("file:///android_asset/index_1.html");
        webRocketView.getSettings().setJavaScriptEnabled(true);
        webRocketView.setWebViewClient(new WebViewClient());

        // Initializing the textView
        txtLaunchDate = findViewById(R.id.txtLaunchDate);
        txtPartners = findViewById(R.id.txtPtDetails);
        txtObjective = findViewById(R.id.txtObjective);

        Nimbus nimbus=(Nimbus) getIntent().getExtras().getSerializable("object");

        // show launch date
        Handler h4 = new Handler();
        h4.postDelayed(new Runnable() {
            @Override
            public void run() {
                txtLaunchDate.setText("Launch Date:\n" +nimbus.getLaunchDate());
            }
        }, 1000);

        Handler h1 = new Handler();
        h1.postDelayed(new Runnable() {
            @Override
            public void run() {
                txtPartners.setText("Partners:\n" + nimbus.getPartener());
            }
        }, 3000);

        Handler h3 = new Handler();
        h3.postDelayed(new Runnable() {
            @Override
            public void run() {
                txtObjective.setText(nimbus.getObjectives());
            }
        }, 6000);


        Handler h2 = new Handler();
        h2.postDelayed(new Runnable() {

            @Override
            public  void run() {
                // show partners
                Intent i = new Intent(RocketLaunch.this, MainActivity.class);
                startActivity(i);
                RocketLaunch.this.finish();
            }
        }, 18000);


    }
}