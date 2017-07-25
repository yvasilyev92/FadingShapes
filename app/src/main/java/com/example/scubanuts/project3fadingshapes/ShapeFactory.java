package com.example.scubanuts.project3fadingshapes;

import android.content.Context;

// Called in class to make shapes
public class ShapeFactory extends AbstractShapeFactory {

    //Constructor for factory
    int border, filler;
    ShapeFactory(int  border, int filler) {
        this.border = border;
        this.filler = filler;
    }

    public static Shape getShape (Context context, int shape, int border, int filler) {
        //Circle
        if (shape == 0) {
            return new Circle(context, border, filler);

        } else if (shape == 1) {    //rectangle
            return new Rectangle(context, border, filler);

        }
        return null;

    }
}
