package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ShapeCollector {

    private final List<Shape> shapeList = new ArrayList<>();

    public int size(){
        return shapeList.size();
    }

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        if(shapeList.contains(shape)){
            shapeList.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int shapeNumber) {

        if(shapeNumber >= 0 && shapeNumber <= this.size()){
            return shapeList.get(shapeNumber);
        }else{
            throw new NoSuchElementException();
        }
    }

    public String showFigures(){

        List<String> figuresList = new ArrayList<>();
        shapeList.forEach(e -> figuresList.add(e.getShapeName()));
        return String.join(", ", figuresList);

    }
}
