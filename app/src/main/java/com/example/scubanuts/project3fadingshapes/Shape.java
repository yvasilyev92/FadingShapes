package com.example.scubanuts.project3fadingshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

 public abstract class Shape extends View {

    float alpha = 1.0f;
    public Shape(Context context) {
        super(context);
    }

    void setShapeAlpha (float alpha) {
        this.alpha = alpha;
        setAlpha(this.alpha);
    }

    float getShapeAlpha () {

        return alpha;
    }

    void removeShape() {
        setVisibility(View.GONE);
    }

    abstract ShapeType getShapeType();


     @Override
    public abstract void onDraw(Canvas canvas);


 }
