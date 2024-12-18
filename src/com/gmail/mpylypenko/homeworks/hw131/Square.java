package com.gmail.mpylypenko.homeworks.hw131;

import java.util.Random;

public class Square implements GeometryFigure {
    private double side;

    public Square() {
        Random random = new Random();
        this.side = Math.floor(random.nextDouble(1001) * 100) / 100;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSidesValues() {
        return Math.floor(this.side * 100) / 100;
    }

    public double area() {
        return Math.floor(Math.pow(this.side, 2) * 100) / 100;
    }

    public String getName() {
        return "Square";
    }
}
