package com.gmail.mpylypenko.homeworks.hw101;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CustomMethods {
    public static void main(String[] args) {
        int integer = askClientEnterInteger("1) Please, enter an integer:");
        int secondPowInteger = squareNumber(integer);
        System.out.println("Your integer in a second power is " + secondPowInteger);

        double radius = askClientEnterDouble("\n2) Please, enter a radius of cylinder:");
        double height = askClientEnterDouble("Please, enter a height of cylinder:");
        double cylinderVolume = calculateCylinderVolume(radius, height);
        System.out.print("Cylinder with radius " + radius + " and height " + height);
        System.out.println(" has a volume " + cylinderVolume);

        int arrayLength = askClientEnterInteger("\n3) Please, enter a length for array:");
        int maxValue = askClientEnterInteger("And max value for array:");
        int[] array = generateArray(arrayLength, maxValue);
        int sumArrayValues = sumAllArrayValues(array);
        System.out.println("Array of numbers:" + Arrays.toString(array));
        System.out.print("Sum of array values is " + sumArrayValues);

        String text = askClientEnterText("\n4) Please, enter some text:");
        String reverseText = reverseText(text);
        System.out.println("Reversed text:" + reverseText);

        int number = askClientEnterInteger("\n5) Please, enter a number:");
        int powerNumber = askClientEnterInteger("And number to power it:");
        double poweredNumber = powNumber(number, powerNumber);
        System.out.println("Result " + number + "^" + powerNumber + " is " + poweredNumber);

        int repeats = askClientEnterInteger("\n6) Please, enter a amount of repeats:");
        String textToRepeat = askClientEnterText("And text to repeat:");
        print(textToRepeat, repeats);
    }

    private static void print(String text, int repeats) {
        for (int i = 1; i <= repeats; i++) {
            System.out.println(i + ". " + text);
        }
    }

    private static double powNumber(int number, int powerNumber) {
        double poweredNumber = number;
        boolean isNegativePower = powerNumber < 0;
        for (int i = Math.abs(powerNumber); i > 1; i--) {
            poweredNumber = poweredNumber * number;
        }
        /* or can be used Math.pow(number, powerNumber) */
        return isNegativePower ? 1 / poweredNumber : poweredNumber;
    }

    private static int squareNumber(int integer) {
        return integer * integer;
    }

    private static double calculateCylinderVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    private static int sumAllArrayValues(int[] array) {
        int sum = 0;
        for (int value: array) {
            sum += value;
        }
        return sum;
    }

    private static String reverseText(String text) {
        String reverseText = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverseText += text.charAt(i);
        }
        return reverseText;
    }

    private static int[] generateArray(int arrayLength, int maxValue) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, maxValue + 1);
        }
        return array;
    }

    private static int askClientEnterInteger(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }

    private static double askClientEnterDouble(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextDouble();
    }

    private static String askClientEnterText(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }
}
