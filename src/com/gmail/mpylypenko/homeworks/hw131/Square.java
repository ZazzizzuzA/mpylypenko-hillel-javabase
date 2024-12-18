package com.gmail.mpylypenko.homeworks.hw131;

import java.util.Random;

public class Square implements GeometryFigure {
    private double sideValue;

    public Square() {
        Random random = new Random();
        this.sideValue = Math.floor(random.nextDouble(1001) * 100) / 100;
    }

    public Square(double sideValue) {
        this.sideValue = sideValue;
    }

    public double getSidesValues() {
        return Math.floor(this.sideValue * 100) / 100;
    }

    public double plane() {
        return Math.floor(Math.pow(this.sideValue, 2) * 100) / 100;
    }

    public String getName() {
        return "Square";
    }
}
