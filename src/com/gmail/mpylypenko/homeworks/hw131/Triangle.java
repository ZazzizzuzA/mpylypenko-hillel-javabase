package com.gmail.mpylypenko.homeworks.hw131;

import java.util.Random;

public class Triangle implements GeometryFigure {
    private double[] sides = new double[3];

    public Triangle() {
        for (int i = 0; i < sides.length; i++) {
            Random random = new Random();
            sides[i] = Math.floor(random.nextDouble(1001) * 100) / 100;
        }
    }

    public Triangle(double[] sideValues) {
        for (int i = 0; i < sideValues.length; i++) {
            this.sides[i] = sideValues[i];
        }
    }

    public double plane() {
        return Math.floor(((this.height() * this.sides[0]) / 2) * 100) / 100;
    }

    private double height() {
        return this.sides[2] * this.sides[1] / this.sides[0];
    }

    public double[] getSidesValues() {
        return this.sides;
    }

    public String getName() {
        return "Triangle";
    }
}
