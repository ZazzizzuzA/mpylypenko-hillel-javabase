package com.gmail.mpylypenko.homeworks.hw81;

import java.util.Random;
import java.util.Scanner;

public class SortAndSearchInArray {
    public static void main(String[] args) {
        int arrayLength = askClientNumber("Please, enter length for your array: ");
        if (arrayLength < 0) {
            printInfo("Can not creates an array with negative length. Bye.");
            return;
        }

        int[] array = generateArray(arrayLength);
        System.out.println("We've created for you array with length " + array.length);
        System.out.print("Origin array: ");
        printArray(array);
        insertionSortAndPrint(array);

        int numberToFind = askClientNumber("Index of which number do you want to get?");
        binarySearchAndPrint(numberToFind, array);
    }

    public static void insertionSortAndPrint(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int n = i - 1;
            for (; n >= 0 && array[n] > key; n--) {
                array[n + 1] = array[n];
                array[n] = key;
            }
        }
        System.out.print("Sorted array by insertion method: ");
        printArray(array);
    }

    private static void binarySearchAndPrint(int value, int[] array) {
        int leftEdge = 0;
        int rightEdge = array.length - 1;
        int indexOfValue = 0;
        boolean isFound = false;
        while (leftEdge <= rightEdge) {
            indexOfValue = (rightEdge + leftEdge) / 2;
            if (array[indexOfValue] == value) {
                isFound = true;
                break;
            }
            if (array[indexOfValue] < value) {
                leftEdge = indexOfValue + 1;
            } else {
                rightEdge = indexOfValue - 1;
            }
        }
        if (isFound) {
            printInfo("Index of your number " + value + " in sorted array is " + indexOfValue + ".");
        } else {
            printInfo("Sorry, but your number " + value + " is missing in sorted array.");
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            System.out.printf("%d", number);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int[] generateArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 100);
        }
        return array;
    }

    private static int askClientNumber(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }

    private static void printInfo(String text) {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(text);
    }
}
