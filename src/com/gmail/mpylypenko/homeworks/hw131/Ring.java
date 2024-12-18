package com.gmail.mpylypenko.homeworks.hw131;

import java.util.Random;

public class Ring implements GeometryFigure {
    private double radius;

    public Ring() {
        Random random = new Random();
        this.radius = Math.floor(random.nextDouble(1001) * 100) / 100;
    }

    public Ring(double radius) {
        this.radius = radius;
    }

    public double plane() {
        return Math.floor((Math.PI * Math.pow(this.radius, 2)) * 100) / 100;
    }

    public double getRadius() {
        return Math.floor(this.radius * 100) / 100;
    }

    public String getName() {
        return "Ring";
    }
}
