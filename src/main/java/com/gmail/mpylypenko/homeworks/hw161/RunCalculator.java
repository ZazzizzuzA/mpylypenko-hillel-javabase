package com.gmail.mpylypenko.homeworks.hw161;

import com.gmail.mpylypenko.calculator.Calculator;

import java.util.Objects;
import java.util.Scanner;

public class RunCalculator {
    static final Scanner scanner = new Scanner(System.in);
    static final Calculator calculator = new Calculator();
    public static void main(String[] args) {
        boolean stop = false;
        while (!stop) {
            String sample = readString("Write sample (only one operation):");
            if (Objects.equals(sample, "stop")) {
                stop = true;
            } else {
                calculate(sample);
            }
        }
    }

    private static void calculate(String sample) {
        double result = calculator.calculate(sample);
        System.out.println(result);
    }

    private static String readString(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }
}
