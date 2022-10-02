package com.example.nasaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;



public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        TextView hindiName = findViewById(R.id.hindi_name);
        TextView englishName = findViewById(R.id.english_name);


        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash);
        videoview.setVideoURI(uri);
        videoview.start();
        Animation hindi_animation= AnimationUtils.loadAnimation(this,R.anim.hindi_name_animation);
        hindiName.startAnimation(hindi_animation);
        Animation english_animation= AnimationUtils.loadAnimation(this,R.anim.english_name_animation);
        englishName.startAnimation(english_animation);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent i = new Intent(splashscreen.this, MainActivity.class);
                splashscreen.this.startActivity(i);
                splashscreen.this.finish();
            }
        }, 6000);

    }
}