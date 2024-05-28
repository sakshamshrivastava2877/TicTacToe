package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_DELAY = 5000; // Delay in milliseconds
    private ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImage = findViewById(R.id.splash_image);

        splashImage.setAlpha(0f);

        splashImage.animate()
                .alpha(1f)
                .setDuration(2000)
                .start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Players.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }
}
