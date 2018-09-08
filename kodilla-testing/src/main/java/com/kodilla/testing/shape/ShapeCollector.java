package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeList = new ArrayList<>();

    public int size(){
        return shapeList.size();
    }

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(shapeList.contains(shape)){
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int shapeNumber){
        Shape desiredShape = null;
        if(shapeNumber >= 0 && shapeNumber <= this.size()){
            desiredShape = shapeList.get(shapeNumber);
        }
        return desiredShape;
    }

    public String showFigures(){
        StringBuilder listOfShapes = new StringBuilder();
        shapeList.forEach(e -> listOfShapes.append(e.getShapeName()));
        return listOfShapes.toString();
    }
}
