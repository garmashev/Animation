package com.example.dev.animation;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView view;
    TextView view_2;
    ViewGroup root;
    private int xDelta;
    private int yDelta;
    int bmpWidth, bmpHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = (ViewGroup)findViewById(R.id.root);
        view = new ImageView(this);
        view_2 = new TextView(this);
        view_2.setText("Test!!!!");
        view.setImageResource(R.mipmap.ic_launcher);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 50);
        layoutParams.leftMargin = 50;
        layoutParams.topMargin = 50;
        layoutParams.bottomMargin = -250;
        layoutParams.rightMargin = -250;
        layoutParams.width = 500;
        layoutParams.height = 500;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(150, 50);
        layoutParams.leftMargin = 150;
        layoutParams.topMargin = 50;
        layoutParams.bottomMargin = -250;
        layoutParams.rightMargin = -250;
        layoutParams.width = 500;
        layoutParams.height = 500;
        view.setLayoutParams(layoutParams);
        view_2.setLayoutParams(layoutParams2);
        view.setOnTouchListener(this);
        view_2.setOnTouchListener(this);
        root.addView(view_2);
        root.addView(view);
        bmpWidth = view.getWidth();
        bmpHeight = view.getHeight();

    }

    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        int fingersCount = event.getPointerCount();
        if(fingersCount == 2){

            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                   
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.height = (int) event.getX();
                    layoutParams.width = (int) event.getY();
                    view.setLayoutParams(layoutParams);
                    break;
            }
        }
        else {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                xDelta = X - lParams.leftMargin;
                yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = X - xDelta;
                layoutParams.topMargin = Y - yDelta;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                view.setLayoutParams(layoutParams);
                break;
        }
        }
        root.invalidate();
        return true;
    }}

