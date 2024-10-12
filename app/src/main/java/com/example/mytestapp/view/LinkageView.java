package com.example.mytestapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mytestapp.R;

public class LinkageView extends FrameLayout {
    private Context context;
    private ImageView checkIv;
    private View view;
    private Paint paint;// 画笔
    private String TAG = "LinkageView";

    public LinkageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // view的子类需要添加这句，否则onDraw()方法不会执行
        setWillNotDraw(false);
        this.context = context;
        initPaint();
        init();
    }

    int sx = 0, sy;
    boolean isMove;
    int gunImgWidth, gunImgHeight;

    private void init() {
        view = LayoutInflater.from(context).inflate(R.layout.view_linkage_layout, this);
        checkIv = view.findViewById(R.id.linkage_check_iv);

        hideView();

        view.post(() -> {
            gunImgWidth = view.getWidth();
            gunImgHeight = view.getHeight();
//                Log.i(TAG,"gunImgWidth = "+gunImgWidth+" gunImgHeight = "+gunImgHeight);
        });

        checkIv.post(() -> {
//            int checkImgWidth = checkIv.getWidth();
//            int checkImgHeight = checkIv.getHeight();
//            Log.i(TAG, "checkImgWidth = " + checkImgWidth + " checkImgHeight = " + checkImgHeight);
            Log.i(TAG, "开始按下手指, left:" + checkIv.getLeft() + ",top =" + checkIv.getTop() + ",right = " + checkIv.getRight() + ",bottom = " + checkIv.getBottom());
            drawLine(checkIv.getLeft(), checkIv.getTop(), checkIv.getRight(), checkIv.getBottom());
            invalidate();
        });
        Glide.with(context).load(R.mipmap.linkage_end).into(checkIv);

        checkIv.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:// 获取手指第一次接触屏幕
                    sx = (int) event.getRawX();
                    sy = (int) event.getRawY();
                    //layout是整个activity的根控件   你想把view的拖拽空间限制在什么范围 就用哪个控件
                    setImageBg(true);
                    drawLine(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                    Log.i(TAG, "按下手指, left:" + v.getLeft() + ",top =" + v.getTop() + ",right = " + v.getRight() + ",bottom = " + v.getBottom());
                    break;
                case MotionEvent.ACTION_MOVE:// 手指在屏幕上移动对应的事件
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    // 获取手指移动的距离
                    int dx = x - sx;
                    int dy = y - sy;

                    // isMove  使用来判断当前控件是否正在被拖拽  用来辅助实现点击空能的  isMove就是一个常量 isMove = false
                    //这个5也是可以根据自己需求更改精度的
                    if (Math.abs(dx) > 5 || Math.abs(dy) > 5) {
                        isMove = true;
                    }

                    int left = v.getLeft() + dx;
                    int top = v.getTop() + dy;
                    int right = v.getRight() + dx;
                    int bottom = v.getBottom() + dy;

                    //这里是给控件设置拖拽边界 开始
                    if (left < 0) {
                        left = 0;
                        right = left + v.getWidth();
                    }
                    if (right > gunImgWidth) {
                        right = gunImgWidth;
                        left = right - v.getWidth();
                    }
                    if (top < 0) {
                        top = 0;
                        bottom = top + v.getHeight();
                    }
                    if (bottom > gunImgHeight) {
                        bottom = gunImgHeight;
                        top = bottom - v.getHeight();
                    }
                    //这里是给控件设置拖拽边界 结束

                    // 更改imageView在窗体的位置
                    v.layout(left, top, right, bottom);
                    if (isMove) {
                        drawLine(left, top, right, bottom);
                    }
                    // 获取移动后的位置
                    sx = (int) event.getRawX();
                    sy = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_UP:// 手指离开屏幕对应事件
                    //是否实现点击事件 根据isMove标签 在这里做处理
                    int leftPos = v.getLeft();
                    int topPos = v.getTop();
                    int rightPos = v.getRight();
                    int bottomPos = v.getBottom();
                    Log.i(TAG, "抬起手指, left:" + leftPos + ",top =" + topPos + ",right = " + rightPos + ",bottom = " + bottomPos);
                    drawLine(leftPos, topPos, rightPos, bottomPos);
//
                    setImageBg(false);
                    Glide.with(context).load(R.mipmap.linkage_end).into(checkIv);
                    invalidate();
                    isMove = false;
                    hideView();
                    break;
            }
            return true;
        });
    }


    private void initPaint() {
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //防抖动
        paint.setDither(true);
        //设置线条宽度（单位px）
        paint.setStrokeWidth(10);
        //设置颜色
        int color = getResources().getColor(R.color.white);
        paint.setColor(color);
    }


    float[] points = null;

    /**
     * 画线
     *
     * @param left   左
     * @param top    上
     * @param right  右
     * @param bottom 下
     */
    private void drawLine(int left, int top, int right, int bottom) {
        points = new float[16];
        // 左
        float startX = 0;
        float startY = (float) (top + bottom) / 2;
        float stopX = left;
        float stopY = (float) (top + bottom) / 2;
//        mCanvas.drawLine(startX, startY, stopX, stopY, paint);
        points[0] = startX;
        points[1] = startY;
        points[2] = stopX;
        points[3] = stopY;
        // 上
        startX = (float) (left + right) / 2;
        startY = 0;
        stopX = (float) (left + right) / 2;
        stopY = top;
//        mCanvas.drawLine(startX, startY, stopX, stopY, paint);
        points[4] = startX;
        points[5] = startY;
        points[6] = stopX;
        points[7] = stopY;
        // 右
        startX = right;
        startY = (float) (top + bottom) / 2;
        stopX = gunImgWidth;
        stopY = (float) (top + bottom) / 2;
//        mCanvas.drawLine(startX, startY, stopX, stopY, paint);
        points[8] = startX;
        points[9] = startY;
        points[10] = stopX;
        points[11] = stopY;
        // 下
        startX = (float) (left + right) / 2;
        startY = bottom;
        stopX = (float) (left + right) / 2;
        stopY = gunImgHeight;
        Log.i(TAG, "startX:" + startX + ",startY =" + startY + ",stopX = " + stopX + ",stopY = " + stopY);
//        mCanvas.drawLine(startX, startY, stopX, stopY, paint);
        points[12] = startX;
        points[13] = startY;
        points[14] = stopX;
        points[15] = stopY;
//        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw()");
        if (points != null) {
            canvas.drawLines(points, paint);
        }
//        path.reset();
//        path.moveTo(100,100);
//        path.lineTo(100,300);
//        path.lineTo(300,200);
//        canvas.drawPath(path, paint);
//        mCanvas.drawLine(0, 0, 1080, 660, paint);
    }

    // 显示view
    public void showView() {
        view.setVisibility(View.VISIBLE);
//        checkIv.setImageResource(R.mipmap.linkage_no_check_icon);
        hideView();
    }

    Handler handler = new Handler();

    // 隐藏view
    private void hideView() {
        // 3秒后自动隐藏
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 3000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "isMove = " + isMove);
            if (!isMove) {
                view.setVisibility(View.INVISIBLE);
                setImageBg(false);
            }
        }
    };

    private void setImageBg(boolean select) {
        checkIv.setSelected(select);
        if (select) {
//            checkIv.setImageResource(R.mipmap.linkage_check_icon);
            paint.setColor(getResources().getColor(R.color.select_tv_color));
        } else {
            paint.setColor(getResources().getColor(R.color.white));
//            checkIv.setImageResource(R.mipmap.linkage_no_check_icon);
        }
    }

}
