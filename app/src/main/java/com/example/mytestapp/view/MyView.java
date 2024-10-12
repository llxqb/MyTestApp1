package com.example.mytestapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mytestapp.R;

public class MyView extends RelativeLayout {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);

    }

    private void init(Context context){
//        View view = LayoutInflater.from(context).inflate(R.layout.text_layout, this);
//        Button text_tv = view.findViewById(R.id.text_tv);
//        TextView text_tv2 = view.findViewById(R.id.text_tv2);
//        text_tv.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("ddd","哈哈哈");
//                Toast.makeText(context, "哈哈哈", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        text_tv2.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.i("ddd","11111");
//                return false;
//            }
//        });

    }

    private int lastX;
    private int firstX;
    private int lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ddd","MyView onTouchEvent");
        //获取到手指处的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN://手指按下时
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE://手指移动时
                //计算移动的距离
                int offX = x - lastX;
                int offY = y - lastY;
                //调用layout方法来重新放置它的位置
                Log.e("TAG","距离左边="+getLeft()+offX+",距离顶部="+getTop()+offY+",距离右边="+ getRight()+offX+",距离底部="+ getBottom()+offY);
                movingXY(offX,offY);
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return false;
    }

    public void movingXY(int offX,int offY){
        //移动View的关键代码
        layout(getLeft()+offX, getTop()+offY,    getRight()+offX    , getBottom()+offY);
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        Log.e("ddd","MyView onTouch");
//
//
//        return false;
//    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        // 拦截所有事件 true: 只执行onTouchEvent方法
        // false: onTouchEvent
        return true;
    }
}
