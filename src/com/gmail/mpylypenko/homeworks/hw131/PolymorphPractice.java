package com.gmail.mpylypenko.homeworks.hw131;

import java.util.Arrays;

public class PolymorphPractice {
    public static void main(String[] args) {
        System.out.println("-=EXAMPLE WITH TRIANGLE=-");
        triangleDemo();
        System.out.println("\n-=EXAMPLE WITH SQUARE=-");
        squareDemo();
        System.out.println("\n-=EXAMPLE WITH RING=-");
        ringDemo();

        System.out.println("\n-=CREATES ARRAY OF FIGURES=-");
        GeometryFigure[] figures = createArrayOfFigures();
        System.out.print("Created array of figures: ");
        for (GeometryFigure figure: figures) {
            System.out.print(figure.getName() + ", ");
        }

        double sumPlanes = sumPlanes(figures);
        System.out.println("\nSum of all planes of figures is: " + sumPlanes);

    }

    private static void triangleDemo() {
        Triangle triangle = new Triangle();
        System.out.println("Triangle's values without parameter: " + Arrays.toString(triangle.getSidesValues()));
        System.out.println("Plane of triangle is " + triangle.area());
        Triangle triangleWithParameters = new Triangle(new double[]{78.2, 56.98, 881.55});
        System.out.println("Triangle's values with parameter: " + Arrays.toString(triangleWithParameters.getSidesValues()));
    }

    private static void squareDemo() {
        Square square = new Square();
        System.out.println("Square's sides without parameter has value: " + square.getSidesValues());
        System.out.println("Plane of square is " + square.area());
        Square squareWithParameters = new Square(40);
        System.out.println("Square's sides values with parameter has value: " + squareWithParameters.getSidesValues());
    }

    private static void ringDemo() {
        Ring ring = new Ring();
        System.out.println("Ring's radius without parameter is: " + ring.getRadius());
        System.out.println("Plane of ring is " + ring.area());
        Ring ringWithParameters = new Ring(100);
        System.out.println("Triangle's radius with parameter is: " + ringWithParameters.getRadius());
    }

    private static GeometryFigure[] createArrayOfFigures() {
        return new GeometryFigure[]{
                new Triangle(),
                new Ring(),
                new Square()
        };
    }

    private static double sumPlanes(GeometryFigure[] figures) {
        double sum = 0;
        for (GeometryFigure figure: figures) {
            sum += figure.area();
        }
        return sum;
    }


}
