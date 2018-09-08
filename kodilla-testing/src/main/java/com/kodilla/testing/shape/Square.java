package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength);
    }

    public double getSideLength() {
        return sideLength;
    }

    public String getShapeName() {
        return "square";
    }

    public double getField() {
        return sideLength * sideLength;
    }

}
