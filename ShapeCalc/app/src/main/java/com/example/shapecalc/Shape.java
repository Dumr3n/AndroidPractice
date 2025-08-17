package com.example.shapecalc;

public class Shape {
    int ShapeImg;
    String ShapeName;

    public Shape(String shapeName, int shapeImg) {
        ShapeName = shapeName;
        ShapeImg = shapeImg;
    }

    public int getShapeImg() {
        return ShapeImg;
    }

    public void setShapeImg(int shapeImg) {
        ShapeImg = shapeImg;
    }

    public String getShapeName() {
        return ShapeName;
    }

    public void setShapeName(String shapeName) {
        ShapeName = shapeName;
    }
}
