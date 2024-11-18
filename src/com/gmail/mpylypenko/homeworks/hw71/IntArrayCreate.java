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
        int[] array = generateArray(arrayLength);

        printArray(array);
        calculateAndPrintSumOfNegativeNumbers(array);
        findAndPrintAmountOddAndEvenNumbers(array);
        findAndPrintBiggestAndSmallestNumber(array);
        calculateAndPrintAverageAfterFirstNegativeNumber(array);
    }

    private static void printArray(int[] array) {
        System.out.println("We've created for you array with length " + array.length);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (i == array.length - 1) {
                System.out.printf("%d", number);
                break;
            }
            System.out.printf("%d, ", number);
        }
        System.out.println("]");
    }

    private static void calculateAndPrintSumOfNegativeNumbers(int[] array) {
        int sum = 0;
        for (int element: array) {
            if (element < 0) {
                sum += element;
            }
        }
        printInfo("Sum of a negative numbers is " + sum);
    }

    private static void findAndPrintAmountOddAndEvenNumbers(int[] array) {
        int oddAmount = 0;
        int evenAmount = 0;
        for (int element: array) {
            if (element % 2 == 0) {
                evenAmount += 1;
            } else {
                oddAmount += 1;
            }
        }
        printInfo("Amount of even numbers is " + evenAmount);
        printInfo("Amount of odd numbers is " + oddAmount);

        /* Resolve using only one variable */

        evenAmount = 0;
        for (int element: array) {
            if (element % 2 == 0) {
                evenAmount += 1;
            }
        }

        printInfo("(using one variable) Amount of even numbers is " + evenAmount);
        printInfo("(using one variable) Amount of odd numbers is " + (array.length - evenAmount));

    }

    private static void findAndPrintBiggestAndSmallestNumber(int[] array) {

        int indexBiggest = 0;
        int indexSmallest = 0;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (array[indexBiggest] < element) {
                indexBiggest = i;
            }
            if (array[indexSmallest] > element) {
                indexSmallest = i;
            }
        }
        printInfo("Biggest number of array with index " + indexBiggest + " is " + array[indexBiggest]);
        printInfo("Smallest number of array with index " + indexSmallest + " is " + array[indexSmallest]);
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

        double average = Math.floor((double) sum / amount * 100) / 100;

        printInfo("Average value after first negative number is " + average);
    }

    private static int[] generateArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-100,100);
        }
        return array;
    }

    private static void printInfo(String text) {
        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(text);
    }

    private static int askClientNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter length for your array: ");
        return scanner.nextInt();
    }
}
