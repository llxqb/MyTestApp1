package com.example.mytestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mytestapp.view.LinkageView;

public class AnimActivity extends AppCompatActivity {
    boolean show = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        LinearLayout linkageLayout =  findViewById(R.id.linkage_layout);
        LinkageView linkageView =  findViewById(R.id.linkage_view);
        Log.i("anim111","onCreate()");

        linkageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("AnimActivity","onClick");
                linkageView.showView();
            }
        });

//        linkageLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.i("AnimActivity","onTouch");
//                return false;
//            }
//        });

        ImageView start_iv = findViewById(R.id.start_iv);
        FrameLayout start_layout = findViewById(R.id.start_layout);
        ImageView bottom_iv = findViewById(R.id.bottom_iv);

        start_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(show){
                    show = false;
                    AnimUtil.showSmallWindowAnim(start_layout,bottom_iv);
                }else {
                    show = true;
                    AnimUtil.hideSmallWindowAnim(start_layout);
                }


            }
        });
        start_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("anim111","onDestroy()");
    }
}