package com.example.scubanuts.project3fadingshapes;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;


public class MainActivity extends AppCompatActivity {

    Vector<Shape> shapeVect = new Vector<>();
    int circCount, rectCount;
    TextView shapeText;
    String shapeNum;
    private int border = 0;
    private int filler = 0;
    private int style = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Delete the action bar!!
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        shapeText = (TextView) findViewById(R.id.textView);

        RectangleButton();
        CircleButton();
        ClearButton();
        StyleButton();
    }

    private void StyleButton() {
        Button styleButton = (Button) findViewById(R.id.styleButton);
        styleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change the styles on click
                border++;
                filler++;
                style++;

                // loop back to 0
                border = border%3;
                filler = filler%3;
                style = style%3;
            }
        });

    }
    private void RectangleButton() {
        Button rectangleButton = (Button) findViewById(R.id.rectangleButton);

        rectangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShapeFactory style1 = AbstractShapeFactory.getShapeFactory(style);
                Shape myRectangle = style1.getShape(v.getContext(), 1, border, filler);
                shapeVect.add(myRectangle);
                RelativeLayout myRelativeLayout = (RelativeLayout) findViewById(R.id.shapesLayout);
                myRelativeLayout.addView(myRectangle);
                rectCount++;
                adjustShapesAlpha();
                updateShapesCount();
            }
        });
    }

    private void CircleButton() {

        Button circleButton = (Button) findViewById(R.id.circleButton);

        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShapeFactory style2 = AbstractShapeFactory.getShapeFactory(style);
                Shape myCircle = style2.getShape(v.getContext(), 0, border, filler);
                shapeVect.add(myCircle);
                RelativeLayout myRelativeLayout = (RelativeLayout) findViewById(R.id.shapesLayout);
                myRelativeLayout.addView(myCircle);
                circCount++;
                adjustShapesAlpha();
                updateShapesCount();
            }
        });
    }

    private void ClearButton() {

        Button clearButton = (Button) findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout myRelativeLayout = (RelativeLayout) findViewById(R.id.shapesLayout);
                myRelativeLayout.removeAllViews();
                circCount = 0;
                rectCount = 0;
                shapeVect.clear();
                updateShapesCount();
            }
        });
    }


    public void adjustShapesAlpha(){
        int i = 0, j = -1;
        for(Shape shapes: shapeVect){
            shapes.setShapeAlpha(shapes.getShapeAlpha() - (float) .1);
            if(shapes.getShapeAlpha() <= (float) 0){
                shapes.removeShape();
            }
        }
        // increment the added shapes
        for(Shape shapes: shapeVect){
            if(shapes.getVisibility() == View.GONE){
                j = i;
            }
            i++;
        }
        // deduct the faded shapes
        if(j != -1){
            if(shapeVect.get(j).getShapeType().equals(ShapeType.RECTANGLE)){
                rectCount--;
            }else{
                circCount--;
            }
            shapeVect.removeElementAt(j);
        }
    }

    public void updateShapesCount(){
        shapeNum = "Rectangles: " + rectCount + " Circles: " + circCount + " Style: " + style;
        shapeText.setText(shapeNum);
    }
}
