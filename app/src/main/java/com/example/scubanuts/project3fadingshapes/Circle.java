package com.example.scubanuts.project3fadingshapes;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Circle extends Shape {
    // private data field
    private int border, filler, bColor, fColor;
    Paint paint;

    public Circle(Context context, int border, int filler) {
        super(context);
        this.border = border;
        this.filler = filler;
        this.paint = new Paint();
    }


    public void onDraw(Canvas canvas) {
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
        Random rand = new Random();
        int x = rand.nextInt(275);
        int y = rand.nextInt(350);
        int r = rand.nextInt(500);

        canvas.drawCircle(x,y,r,paint);

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

        canvas.drawCircle(x,y,r,paint);

    }
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }
}
