package com.example.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mytestapp.gLSurfaceView.MyGLSurfaceView;
import com.example.mytestapp.gLSurfaceView.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GLSurfaceActivity extends AppCompatActivity {

    private String TAG = "GLSurfaceActivity";
    private float[] vertexArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glsurface);

        MyGLSurfaceView myGLSurfaceView = findViewById(R.id.gl_view);
        initVertexArray(100);
        myGLSurfaceView.getMyGLRender().setPointSize(1f);

        try {
            ArrayList<Float> floats = Tool.readFile(getResources().openRawResource(R.raw.costmap));
            ArrayList<Float> transfer = Tool.transfer(floats);
            Float[] floats1 = transfer.toArray(new Float[transfer.size()]);
            Log.d(TAG, "onCreate: floats size = "+floats1.length);
            float[] vertex = new float[floats1.length];
            for (int i =0;i< floats1.length;++i){
                vertex[i] = floats1[i];
            }
            myGLSurfaceView.updateData(vertex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //test array
    void initVertexArray(int size){
        vertexArray = new float[size * 3 * 3];
        Random random = new Random();
        int index = 0;
        float x_add = 0.01f;
        for (int i = 0;i < size ; ++i){
            float v = random.nextFloat();
            vertexArray[index] = x_add;
            x_add += 0.01f;
            ++index;
            v = random.nextFloat();
            vertexArray[index] = 0.0f;
            ++index;
            vertexArray[index] = 0.0f;
            ++index;
        }
        x_add = 0.01f;
        for (int i = 0;i < size ; ++i){
            float v = random.nextFloat();
            vertexArray[index] = x_add;
            x_add += 0.01f;
            ++index;
            v = random.nextFloat();
            vertexArray[index] = 0.01f;
            ++index;
            vertexArray[index] = 0.0f;
            ++index;
        }

        float y_add = 0.01f;
        for (int i = 0;i < size ; ++i){
            float v = random.nextFloat();
            vertexArray[index] = 0.0f;
            y_add += 0.01f;
            ++index;
            v = random.nextFloat();
            vertexArray[index] = y_add;
            ++index;
            vertexArray[index] = 0.0f;
            ++index;
        }

    }
}