package com.example.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytestapp.view.MyView;
import com.example.mytestapp.view.MyView2;

public class MoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        MyView2 myView = findViewById(R.id.myView2);
//        myView.setView((View)myView.getParent());

//        MyView myView = findViewById(R.id.myView);
//        myView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.i("ddd","111");
//                return false;
//            }
//        });
//        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) myView.getLayoutParams();
//        layoutParams2.width = 200;
//        layoutParams2.height = 200;



//        TextView text1 = findViewById(R.id.text1);
//
//        Button text2 = findViewById(R.id.text2);
//        text2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) text1.getLayoutParams();
//                layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
//                layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
//            }
//        });

//        myView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e("ddd","MoveActivity onTouch");
//
//                switch (v.getId()){
//                    case R.id.text2:
//                        Log.e("ddd","text2");
//                        break;
//                    default:
//                        Log.e("ddd","其它");
//                        break;
//                }
//                // return true , 拦截setOnClickListener ,MyView onTouchEvent 和 onTouch 事件不会执行
//                return false;// true拦截setOnClickListener
//            }
//        });

//        myView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("ddd","MoveActivity onClick");
//            }
//        });
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        Log.e("ddd","onConfigurationChanged");
//    }
}