package com.example.scubanuts.project3fadingshapes;

public enum ShapeType {
    // Identifiers
    CIRCLE(0), RECTANGLE(1);

    private int intValue;
    ShapeType(int value) {
        this.intValue = value;
    }

    public int getIntValue() {

        return intValue;
    }

}
