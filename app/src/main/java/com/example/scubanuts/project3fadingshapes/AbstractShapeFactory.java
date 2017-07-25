package com.example.scubanuts.project3fadingshapes;

public abstract class AbstractShapeFactory {
    public static ShapeFactory getShapeFactory(int style) {
        // retrieve from shapeFactory
        return new ShapeFactory(style, style);
    }

}
