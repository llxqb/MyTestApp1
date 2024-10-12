package com.example.mytestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class FirstActivity extends AppCompatActivity {
    ConstraintLayout rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        rootLayout = findViewById(R.id.root_layout);
        FrameLayout leftLayout = findViewById(R.id.left_layout);
        FrameLayout rightLayout = findViewById(R.id.right_layout);
        String data = getIntent().getStringExtra("data");
        Log.e("ddd","FirstActivity data = "+data);

        View view = LayoutInflater.from(this).inflate(R.layout.mine_text_layout, rootLayout,false);
        leftLayout.addView(view);

        (leftLayout).removeView(view);
        rightLayout.addView(view);
    }


//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent();
//        intent.putExtra("data2","hhhh");
//        setResult(0);
//        finish();
//    }


    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("data2","hhhh");
        setResult(0,intent);
        super.finish();
    }
}