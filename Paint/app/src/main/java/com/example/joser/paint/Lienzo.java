package com.example.joser.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by joser on 20/10/2016.
 */
public class Lienzo extends View {
    //variable de guardar traso
    private Path drawPath;
    //variable paint
    private Paint drawPaint, canvasPaint;
    //variable de color inicial
    private int paintColor = 13371904;
    //variable canvas
    private Canvas drawCanvas;
    //variable bitmap
    private Bitmap bitmapCanvas;
    public Lienzo(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    /**
     * tamaño asignado a la vista
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmapCanvas = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(bitmapCanvas);
    }

    /**
     * pinta la vista del canvas
     * @param canvas variable drawCanvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmapCanvas,0,0,canvasPaint);
        canvas.drawPath(drawPath,drawPaint);
    }

    /**
     * evento onTouchEvent a ejecutar en el lienzo
     * @param event variable del evento
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //variable float del eje x
        float touchX = event.getX();
        //variable float del eje y
        float touchY = event.getY();
        //swicht de eventos del touch event
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawPath.lineTo(touchX,touchY);
                drawCanvas.drawPath(drawPath,drawPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }
        //repintar
        invalidate();
        return true;
    }

    public void setupDrawing(){
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

}
