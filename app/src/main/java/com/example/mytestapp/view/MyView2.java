package com.example.mytestapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mytestapp.R;

public class MyView2 extends RelativeLayout {
    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MyView2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private int mWidth,mHeight;
    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_layout, this);
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.getDefaultDisplay().getMetrics(metric);
        mWidth = metric.widthPixels; // 屏幕宽度（像素）
        mHeight = metric.heightPixels; // 屏幕高度（像素）
        TextView text_tv2 = findViewById(R.id.text_tv2);
        text_tv2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("ddd","111");
                return true;
            }
        });

    }


    private int sx, sy;
    int screenWidth, screenHeight;
    boolean isMove;
    private View mView;

    public void setView(View view ){
        mView = view;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:// 获取手指第一次接触屏幕
//                sx = (int) event.getRawX();
//                sy = (int) event.getRawY();
//                //layout是整个activity的根控件   你想把view的拖拽空间限制在什么范围 就用哪个控件
//                if(mView ==null){
//                    screenWidth = mWidth;
//                    screenHeight = mHeight;
//                }else {
//                    screenWidth = mView.getWidth();
//                    screenHeight = mView.getHeight();
//                }
//
//                break;
//            case MotionEvent.ACTION_MOVE:// 手指在屏幕上移动对应的事件
//
//                int x = (int) event.getRawX();
//                int y = (int) event.getRawY();
//                // 获取手指移动的距离
//                int dx = x - sx;
//                int dy = y - sy;
//
//                // isMove  使用来判断当前控件是否正在被拖拽  用来辅助实现点击空能的  isMove就是一个常量 isMove = false
//                //这个5也是可以根据自己需求更改精度的
//                if (Math.abs(dx) > 5 && Math.abs(dy) > 5) {
//                    isMove = true;
//                }
//
//
//                int left = getLeft() + dx;
//                int top = getTop() + dy;
//                int right = getRight() + dx;
//                int bottom = getBottom() + dy;
//
//                //这里是给控件设置拖拽边界 开始
//                if (left < 0) {
//                    left = 0;
//                    right = left + getWidth();
//                }
//                if (right > screenWidth) {
//                    right = screenWidth;
//                    left = right - getWidth();
//                }
//                if (top < 0) {
//                    top = 0;
//                    bottom = top + getHeight();
//                }
//                if (bottom > screenHeight) {
//                    bottom = screenHeight;
//                    top = bottom - getHeight();
//                }
//                //这里是给控件设置拖拽边界 结束
//
//                // 更改imageView在窗体的位置
//                layout(left, top, right, bottom);
//                // 获取移动后的位置
//                sx = (int) event.getRawX();
//                sy = (int) event.getRawY();
//                break;
//            case MotionEvent.ACTION_UP:// 手指离开屏幕对应事件
//                //是否实现点击事件 根据isMove标签 在这里做处理
//                if (isMove) {
//                    // TODO: 2019/10/18  想要在拖拽之后设置边界的  可以在这里写上面的逻辑
//                    isMove = false;
//
//                    int lastX = (int) event.getRawX();
//                    int lastY = (int) event.getRawY();
//
//                    return true;
//                } else {
////                        finish();
//                }
//
//                break;
//        }
//        return true;
    }


    public void movingXY(int offX, int offY) {
        //移动View的关键代码
        layout(getLeft() + offX, getTop() + offY, getRight() + offX, getBottom() + offY);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        // 拦截所有事件 true: 只执行onTouchEvent方法  实现可拖拽
        // false: onTouchEvent
        return false;
    }
}
