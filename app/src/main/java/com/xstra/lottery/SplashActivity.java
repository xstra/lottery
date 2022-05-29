package com.xstra.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity<animationView_runnable> extends AppCompatActivity {


    com.airbnb.lottie.LottieAnimationView animationView;
    Handler animationView_handler=new Handler(Looper.getMainLooper());
    Runnable animationView_runnable=new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        animationView=findViewById(R.id.animationView);
        animationView_handler.postDelayed(animationView_runnable,3000);
        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationView_handler.removeCallbacks(animationView_runnable);
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}