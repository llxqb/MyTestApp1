package com.example.mytestapp.view;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MyTextView extends TextView implements View.OnTouchListener{

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("Demo:","子View的dispatchTouchEvent方法执行了");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("Demo:","子View的onTouchEvent方法执行了");
        return super.onTouchEvent(event);
    }


    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs,int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.e("Demo:","子View的onTouch方法执行了");
        return false;
    }
}
