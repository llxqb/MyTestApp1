package com.example.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class TestViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);

        TextView txt1 = findViewById(R.id.txt1);
        TextView test_tv = findViewById(R.id.test_tv);
        txt1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e("Demo:","txt1 onTouch 执行了");
                return false;
            }
        });

        test_tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e("Demo:","test_tv onTouch 执行了");
                return false;
            }
        });


    }

    public void testView(View view){
        Log.e("Demo:","testView执行了");
    }
}