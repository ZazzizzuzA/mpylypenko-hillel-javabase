package com.gmail.mpylypenko.calculator;

import java.util.Scanner;

public class ReadScanner {
    static final Scanner scanner = new Scanner(System.in);

    public String readString(String text) {
        System.out.println(text);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int readInt(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }

    public int readIntWithVariants(String text, Operation[] variants) {
        System.out.println(text);
        this.printVariants(variants);
        System.out.println("You choosing:");
        return scanner.nextInt();
    }

    private void printVariants(Operation[] variants) {
        for (int i = 1; i <= variants.length; i++) {
            System.out.println(i + " - " + variants[i - 1]);
        }
    }
}
