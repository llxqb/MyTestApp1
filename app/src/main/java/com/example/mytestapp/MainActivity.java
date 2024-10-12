package com.example.mytestapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mytestapp.logcat.LogcatManager;
import com.example.mytestapp.logcat.LogcatUtils;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ddd","onCreate");
        // 开始捕获
        LogcatManager.start();
        initView();
    }

    private void initView(){
        TextView textView = findViewById(R.id.text_tv);
        TextView animalTv = findViewById(R.id.animal_tv);
        TextView tabLayout = findViewById(R.id.tab_layout);
        TextView viewLayout = findViewById(R.id.view_layout);
        TextView changeLandPortTv = findViewById(R.id.change_land_port_tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
//                intent.putExtra("data","哈哈哈哈");
//                startActivityForResult(intent,100);
                textView.setText("1111111222222");
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });

        animalTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AnimActivity.class);
                startActivity(intent);
            }
        });
        tabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TabLayoutActivity.class);
                startActivity(intent);
            }
        });
        viewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,GLSurfaceActivity.class);
//                startActivity(intent);
                Intent intent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(intent);
            }
        });

        changeLandPortTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SwitchingScreensActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("ddd","requestCode = "+requestCode+" resultCode = "+resultCode);
        if(data!=null){
           String data2 =  data.getStringExtra("data2");
           Log.e("ddd","data2 = "+data2);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ddd","onResume");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("ddd","onConfigurationChanged");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ddd","onPause");

        try {
            File file = LogcatUtils.saveLogToFile(this, LogcatManager.logcatInfoList);
            Log.d("ddd","file = "+file.getName());
//            Log.d("ddd","logcatInfoList = "+LogcatManager.logcatInfoList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}