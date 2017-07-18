package com.xseed.dx.parent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Manvendra sah
 */
public class SplashActivity extends AppCompatActivity {
    private static final int AUTO_HIDE_DELAY_MILLIS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        }, AUTO_HIDE_DELAY_MILLIS);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}