package com.gmail.mpylypenko.homeworks.hw81;

import java.util.Random;
import java.util.Scanner;

public class SortAndSearchInArray {
    public static void main(String[] args) {
        int arrayLength = askClientNumber();
        if (arrayLength < 0) {
            printInfo("Can not creates an array with negative length. Bye.");
            return;
        }
        int[] array = generateArray(arrayLength);

        printArray(array);
        insertionSort(array);
    }

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            for (int n = i - 1; n >= 0; n--) {
                if (array[n] > key) {
                    array[n + 1] = array[n];
                    array[n] = key;
                }
            }

            System.out.print("\nSorted insertion 1: \n[");
            for (int el: array) {
                System.out.print(el + ", ");
            }
            System.out.print("]");
        }

//        int n = array.length;
//        for (int i = 1; i < n; i++) {
//            int key = array[i];
//            int j = i - 1;
//            while (j >= 0 && array[j] > key) {
//                // Переміщення елементів, які більше за key, на одну позицію вперед
//                array[j + 1] = array[j];
//                j--;
//            }
//            // Вставлення key на правильну позицію у відсортованій частині масиву
//            array[j + 1] = key;
//
//            System.out.print("\nSorted insertion 2: \n[");
//            for (int el: array) {
//                System.out.print(el + ", ");
//            }
//            System.out.print("]");
//        }
    }

    private static void printArray(int[] array) {
        System.out.println("We've created for you array with length " + array.length);
        System.out.print("Origin array: \n[");
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

    private static int[] generateArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 100);
        }
        return array;
    }

    private static int askClientNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter length for your array: ");
        return scanner.nextInt();
    }

    private static void printInfo(String text) {
        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(text);
    }
}
