package com.example.harshendra.simpledraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SimpleDrawingView extends View {

    // Initial Color
    private final int paintColor = Color.BLACK;
    // Define Paint and Canvas
    private Paint drawPaint;
    // Stores Points to draw circles each time user touches
    private List<Point> circlePoints;

    private Path path = new Path();

    Canvas myCanvas;
    static Bitmap myCanvasBitmap;
    Matrix identityMatrix;

    public SimpleDrawingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
        circlePoints = new ArrayList<>();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        /* for (Point p : circlePoints) {
            canvas.drawCircle(p.x, p.y, 5, drawPaint);
        } */
        myCanvas.drawPath(path, drawPaint);
        //canvas.drawPath(path, drawPaint);
        canvas.drawBitmap(myCanvasBitmap, identityMatrix, null);
    }

    // Append new circle each time user presses on screen
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //float touchX = event.getX();
        //float touchY = event.getY();
        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Starts a new line in the path
                path.moveTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_MOVE:
                // Draws line between last point and this poin
                path.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }
        //circlePoints.add(new Point(Math.round(touchX), Math.round(touchY)));
        // indicate view should be redrawn
        postInvalidate();
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        myCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        myCanvas = new Canvas();
        myCanvas.setBitmap(myCanvasBitmap);

        identityMatrix = new Matrix();

        setMeasuredDimension(w, h);
    }

    public static Bitmap getCanvasBitmap(){

        return myCanvasBitmap;

    }


    // Setup Paint with color and stroke style
    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

}
