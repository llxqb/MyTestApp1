package com.example.mytestapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLayout extends LinearLayout {

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.e("Demo:","父View的dispatchTouchEvent方法执行了");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("Demo:","父View的onInterceptTouchEvent方法执行了");
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("Demo:","父View的onTouchEvent方法执行了");
//        return super.onTouchEvent(event);
        return false;
    }

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context,AttributeSet attr) {
        super(context,attr);
    }
}
