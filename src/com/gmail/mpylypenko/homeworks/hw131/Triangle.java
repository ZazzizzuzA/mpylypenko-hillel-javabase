package com.gmail.mpylypenko.homeworks.hw131;

import java.util.Random;

public class Triangle implements GeometryFigure {
    private double[] sides = new double[3];

    public Triangle() {
        Random random = new Random();
        for (int i = 0; i < sides.length; i++) {
            sides[i] = Math.floor(random.nextDouble(501) * 100) / 100;
        }
    }

    public Triangle(double[] sideValues) {
        for (int i = 0; i < sideValues.length; i++) {
            this.sides[i] = sideValues[i];
        }
    }

    public double area() {
        double halfPerimeter = (this.sides[0] + this.sides[1] + this.sides[2]) / 2;
        return Math.floor(Math.sqrt(halfPerimeter * (halfPerimeter - this.sides[0]) * (halfPerimeter - this.sides[1]) * (halfPerimeter - this.sides[2])) * 100) / 100;
    }

    public double[] getSidesValues() {
        return this.sides;
    }

    public String getName() {
        return "Triangle";
    }
}
