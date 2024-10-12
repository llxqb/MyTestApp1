package com.example.mytestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SwitchingScreensActivity extends AppCompatActivity {

    private String TAG = "SwitchingScreensActivity";
    boolean screenIsPort = true;//设置屏幕默认竖屏
    TextView changeScreenTv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switching_screens);
        Log.i(TAG, "onCreate()");
        changeScreenTv = findViewById(R.id.change_screen_tv);

        btn = findViewById(R.id.btn);
        initEvent();
    }


    private void initEvent() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setVisibility(View.GONE);
            }
        });
    }

    public void changeScreenBtn(View view) {
        Log.i(TAG, "screenIsPort = " + screenIsPort);
        if (screenIsPort) {
            // 设置横屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            screenIsPort = false;
        } else {
            // 设置竖屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            screenIsPort = true;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "orientation = " + newConfig.orientation);
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            setContentView(R.layout.activity_switching_screens);
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            setContentView(R.layout.activity_switching_screens_land);
//        }

    }



}