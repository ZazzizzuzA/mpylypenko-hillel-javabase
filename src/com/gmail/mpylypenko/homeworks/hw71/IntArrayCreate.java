package com.gmail.mpylypenko.homeworks.hw71;

import java.util.Scanner;

public class IntArrayCreate {
    public static void main(String[] args) {
        int arrayLength = askClientNumber();
    }

    private static int askClientNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter any number: ");
        return scanner.nextInt();
    }
}
