package com.gmail.mpylypenko.homeworks.hw61;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        int clientNumber = askClientNumber();
        displayNumberAndSum(clientNumber);
    }

    private static int askClientNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter any number: ");
        return scanner.nextInt();
    }

    private static void displayNumberAndSum(int clientNumber) {
        logicFor(clientNumber);
        logicWhile(clientNumber);
        logicDoWhile(clientNumber);
    }

    private static void logicFor(int clientNumber) {
        System.out.println("-=LOGIC CYCLE 'FOR'=-");
        int sum = 0;
        for (int i = 1; i <= clientNumber; i++) {
            sum += i;
            System.out.print(i + ") Number is " + i);
            System.out.println(" sum is " + sum);
        }
        System.out.println("----------------------------");
        System.out.println("Sum of numbers " + sum);
    }

    private static void logicWhile(int clientNumber) {
        System.out.println("-=LOGIC CYCLE 'WHILE'=-");
        int sum = 0;
        int number = 1;
        while(number <= clientNumber) {
            sum += number;
            System.out.print(number + ") Number is " + number);
            System.out.println(" sum is " + sum);
            ++number;
        }
        System.out.println("----------------------------");
        System.out.println("Sum of numbers " + sum);
    }

    private static void logicDoWhile(int clientNumber) {
        System.out.println("-=LOGIC CYCLE 'DO...WHILE'=-");
        int sum = 0;
        int number = 1;
        do {
            sum += number;
            System.out.print(number + ") Number is " + number);
            System.out.println(" sum is " + sum);
            ++number;
        } while(number <= clientNumber);
        System.out.println("----------------------------");
        System.out.println("Sum of numbers " + sum);
    }
}
