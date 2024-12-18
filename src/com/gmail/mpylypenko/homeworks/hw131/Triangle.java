package com.gmail.mpylypenko.homeworks.hw131;

import java.util.Random;

public class Triangle implements GeometryFigure {
    private double[] sides = new double[3];

    public Triangle() {
        Random random = new Random();
        for (int i = 0; i < sides.length; i++) {
            sides[i] = Math.floor(random.nextDouble(1001) * 100) / 100;
        }
    }

    public Triangle(double[] sideValues) {
        for (int i = 0; i < sideValues.length; i++) {
            this.sides[i] = sideValues[i];
        }
    }

    public double area() {
        return Math.floor((this.sides[2] * this.sides[1] / 2) * 100) / 100;
    }

    public double[] getSidesValues() {
        return this.sides;
    }

    public String getName() {
        return "Triangle";
    }
}
