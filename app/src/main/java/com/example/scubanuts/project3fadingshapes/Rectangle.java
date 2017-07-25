package com.example.scubanuts.project3fadingshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.Random;

public class Rectangle extends Shape {
    // private data field
    private int border, filler, bColor, fColor;
    Paint paint;

    // constructor with color
    public Rectangle(Context context, int border, int filler) {
        super(context);
        this.border = border;
        this.filler = filler;
        this.paint = new Paint();
    }

    public void onDraw(Canvas canvas) {
        // default random color
        Random rand = new Random();
        paint.setStyle(Paint.Style.FILL);


        // handle filler colors
        if (filler == 0) {
            fColor = Color.BLUE;
        } else if (filler == 1) {
            fColor = Color.MAGENTA;
        } else if (filler == 2) {
            fColor = Color.CYAN;
        }

        // set the fill color
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(fColor);

        // draw the fill
        int x = rand.nextInt(275);
        int y = rand.nextInt(350);
        int z = rand.nextInt(1200);
        int w = rand.nextInt(1200);
        canvas.drawRect(x,y,z,w,paint);

        // handle the border color
        if (border == 0) {
            bColor = Color.BLACK;
        } else if (border == 1) {
            bColor = Color.RED;
        } else if (border == 2) {
            bColor = Color.DKGRAY;
        }

        // set border color
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(15);
        this.paint.setColor(bColor);

        canvas.drawRect(x,y,z,w,paint);}

    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }
}
