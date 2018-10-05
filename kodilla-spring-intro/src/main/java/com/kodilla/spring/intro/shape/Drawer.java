package com.kodilla.spring.intro.shape;

public class Drawer {
    public void doDrawing() {
        Shape shape;

        shape = new Circle();
        shape.draw();

        shape = new Triangle();
        shape.draw();
    }
}