package com.example.mytestapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytestapp.view.CartEvaluator;

public class AnimUtil {

//    public static void showSmallWindowAnim(View startView, View endView, Activity context){
//        //创建int数组，用来接收贝塞尔起始点坐标和终点坐标值
//        int[] startPosition = new int[2];
//        int[] endPosition = new int[2];
//
//        startView.getLocationInWindow(startPosition);
//        endView.getLocationInWindow(endPosition);
//
//        PointF startF = new PointF();        //起始点 startF
//        PointF endF = new PointF();          //终点 endF
//        PointF controlF = new PointF();      //控制点 controlF
//
//        startF.x = startPosition[0];
//        startF.y = startPosition[1] ;
//        endF.x = endPosition[0]+endView.getWidth()/2-startView.getWidth()/2;             //微调处理，确保动画执行完毕“添加”图标中心点与购物车中心点重合
//        endF.y = endPosition[1]+endView.getHeight()/2 - startView.getHeight()/2;
//        controlF.x = endF.x;
//        controlF.y = startF.y;
//
//        // 创建执行动画的“添加”图标
//        final ImageView imageView = new ImageView(context);
//        ((ViewGroup) context.getWindow().getDecorView()).addView(imageView);
//        imageView.setImageResource(R.mipmap.linkage_check_icon);
//        imageView.getLayoutParams().width = startView.getMeasuredWidth();
//        imageView.getLayoutParams().height = startView.getMeasuredHeight();
//
//        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CartEvaluator(controlF), startF, endF);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                PointF pointF = (PointF) animation.getAnimatedValue();
//                imageView.setX(pointF.x);
//                imageView.setY(pointF.y);
//            }
//        });
//
//        valueAnimator.addListener(new AnimatorListenerAdapter() {
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//                // 动画执行完毕，将执行动画的“添加”图标移除掉
////                mRootView.removeView(imageView);
//
//                // 执行购物车缩放动画
//                AnimatorSet animatorSet = new AnimatorSet();
//                ObjectAnimator animatorX = ObjectAnimator.ofFloat(endView, "scaleX", 1f, 1.2f, 1f);
//                ObjectAnimator animatorY = ObjectAnimator.ofFloat(endView, "scaleY", 1f, 1.2f, 1f);
//                animatorSet.play(animatorX).with(animatorY);
//                animatorSet.setDuration(400);
//                animatorSet.start();
//            }
//        });
//
//        valueAnimator.setDuration(800);
//        valueAnimator.start();
//    }

    public static void showSmallWindowAnim(View startView, View endView){
        float startViewX = startView.getX();
        float startViewY = startView.getY();
        float endViewX = endView.getX();
        float endViewY = endView.getY();

        Log.i("ddd","startViewX = "+startViewX+" , startViewY = "+startViewY+" ,endViewX = "+endViewX+" , endViewY= "+endViewY);

        float controlX = endViewX - startViewX;
        float controlY = endViewY - startViewY - startView.getHeight();

        Log.i("ddd","controlX = "+controlX+" , controlY = "+controlY);
        //创建int数组，用来接收贝塞尔起始点坐标和终点坐标值
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(startView, "translationX", controlX);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(startView, "translationY",controlY );
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
//        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(startView, "scaleX", 1f, 0);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(startView, "scaleY", 1f, 0);
        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(moveIn).with(moveY);
        animSet.setDuration(2000);
        animSet.playTogether(moveIn,moveY,scaleX,scaleY);
        animSet.start();


    }


    public static void hideSmallWindowAnim(View startView){
        float startViewX = startView.getX();
        float startViewY = startView.getY();

        Log.i("ddd","startViewX = "+startViewX+" , startViewY = "+startViewY);

        //创建int数组，用来接收贝塞尔起始点坐标和终点坐标值
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(startView, "translationX", 0);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(startView, "translationY",0 );
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
//        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(startView, "scaleX", 0, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(startView, "scaleY", 0, 1f);
        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(moveIn).with(moveY);
        animSet.setDuration(2000);
        animSet.playTogether(moveIn,moveY,scaleX,scaleY);
        animSet.start();
    }
}
