package com.gmail.mpylypenko.homeworks.hw161;

import com.gmail.mpylypenko.calculator.Calculator;
import com.gmail.mpylypenko.calculator.Operation;

public class RunCalculator {
    static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        calculateKnownValues();
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

    private static void calculateKnownValues() {
        double result = calculator.calculate(64, 8, Operation.DIVIDE);
        System.out.println("The result of divide 64 / 8 = " + result);
    }

}
