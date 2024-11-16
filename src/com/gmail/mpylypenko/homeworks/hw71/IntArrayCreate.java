package com.gmail.mpylypenko.homeworks.hw71;

import java.util.Random;
import java.util.Scanner;

public class IntArrayCreate {
    public static void main(String[] args) {
        int arrayLength = askClientNumber();
        if (arrayLength < 0) {
            printInfo("Can not creates an array with negative length. Bye.");
            return;
        }
        int[] array = generateArray(new int[arrayLength]);
        printInfo("We've created for you array with length ", arrayLength);

        calculateAndPrintSumOfNegativeNumbers(array);
        findAndPrintAmountOddAndEvenNumbers(array);
        findAndPrintBiggestAndSmallestNumber(array);
        calculateAndPrintAverageAfterFirstNegativeNumber(array);
    }

    private static void calculateAndPrintSumOfNegativeNumbers(int[] array) {
        int sum = 0;
        for (int element: array) {
            if (element < 0) {
                sum += element;
            }
        }
        printInfo("Sum of a negative numbers is ", sum);
    }

    private static void findAndPrintAmountOddAndEvenNumbers(int[] array) {
        int oddAmount = 0;
        int evenAmount = 0;
        for (int element: array) {
            if (element % 2 == 0) {
                evenAmount += 1;
                continue;
            }
            oddAmount += 1;
        }
        printInfo("Amount of even numbers is ", evenAmount);
        printInfo("Amount of odd numbers is ", oddAmount);
    }

    private static void findAndPrintBiggestAndSmallestNumber(int[] array) {
        int biggestNumber = array[0];
        int smallestNumber = array[0];
        int indexBiggest = 0;
        int indexSmallest = 0;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (biggestNumber < element) {
                biggestNumber = element;
                indexBiggest = i;
            }
            if (smallestNumber > element) {
                smallestNumber = element;
                indexSmallest = i;
            }
        }
        printInfo("Biggest number of array with index " + indexBiggest + " is ", biggestNumber);
        printInfo("Smallest number of array with index " + indexSmallest + " is ", smallestNumber);
    }

    private static void calculateAndPrintAverageAfterFirstNegativeNumber(int[] array) {
        int sum = 0;
        int amount = 0;
        for (int element: array) {
            if (element >= 0) {
                continue;
            }
            sum += element;
            amount += 1;
        }

        if (amount == 0) {
            printInfo("The array doesn't include negative numbers.");
            return;
        }

        int average = sum / amount;

        printInfo("Average value after first negative number is ", average);
    }

    private static int[] generateArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-100,100);
        }
        return array;
    }

    private static void printInfo(String text, int value) {
        System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.println(text + value);
    }

    private static void printInfo(String text) {
        System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.println(text);
    }

    private static int askClientNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter length for your array: ");
        return scanner.nextInt();
    }
}
