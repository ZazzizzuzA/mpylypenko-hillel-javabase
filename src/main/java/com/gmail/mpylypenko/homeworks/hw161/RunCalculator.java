package com.gmail.mpylypenko.homeworks.hw161;

import com.gmail.mpylypenko.calculator.Calculator;

public class RunCalculator {
    static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        startCalculator();
    }

    private static void startCalculator() {
        boolean stop = false;
        while (!stop) {
            System.out.println("-=========================-");
            calculateSeparateValues();
            stop = calculator.askNextSample();
        }
    }

    private static void calculateSeparateValues() {
        double result = calculator.calculate();
        System.out.println("The result is " + result);
    }

}
