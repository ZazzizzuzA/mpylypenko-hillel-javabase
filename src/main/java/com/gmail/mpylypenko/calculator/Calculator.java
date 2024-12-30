package com.gmail.mpylypenko.calculator;

import java.util.Arrays;
import java.util.Objects;

public class Calculator {
    private double numberFirst = -0.0;
    private double numberSecond = -0.0;

    public Calculator() {
        System.out.println("Calculator started and ready to calculate!");
        System.out.println("For exit type 'stop'");
    }

    public double calculate (String example) {
        this.getNumbers(example);
        double result = this.detectAndUseOperation(example);
        this.clearValues();
        return result;
    }

    private void getNumbers(String example) {
        String[] splitExample = example.split("[+#\\-*/]");
        if (splitExample.length > 5) {
            throw new Error("Invalid sample to calculate. Sample: " + example);
        }

        for (int i = 0; i < splitExample.length; i++) {
            if (Objects.equals(splitExample[i], "") && !Objects.equals(splitExample[i + 1], "")) {
                splitExample[i + 1] = "-" + splitExample[i + 1];
            };
            if (!Objects.equals(splitExample[i], "") && this.numberFirst == -0.0) {
                this.numberFirst = Double.parseDouble(splitExample[i]);
                continue;
            }
            if (!Objects.equals(splitExample[i], "") && this.numberSecond == -0.0) {
                this.numberSecond = Double.parseDouble(splitExample[i]);
                break;
            }
        }
        System.out.println(this.numberFirst + ", " + this.numberSecond);
    }

    private double detectAndUseOperation(String example) {
        if (example.contains("+")) {
            return this.plus(this.numberFirst, this.numberSecond);
        }
        if (example.contains("*")) {
            return this.multiply(this.numberFirst, this.numberSecond);
        }
        if (example.contains("/")) {
            return this.divide(this.numberFirst, this.numberSecond);
        }
        if (example.contains("-")) {
            return this.minus(this.numberFirst, this.numberSecond);
        }
        throw new Error("Invalid sample to calculate. Sample: " + example);
    }

    private double plus(double a, double b) {
        return a + b;
    }

    private double divide(double a, double b) {
        return a / b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double minus(double a, double b) {
        return a - b;
    }

    private void clearValues() {
        this.numberSecond = 0.0;
        this.numberFirst = 0.0;
    }
}
