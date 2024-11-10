package com.gmail.mpylypenko.homeworks.hw51.taxes;

import java.util.Scanner;

public class TaxOnRevenue {
    private static double FIRST_LVL_TAXES = 2.5;
    private static double SECOND_LVL_TAXES = 4.3;
    private static double THIRD_LVL_TAXES = 6.7;
    private static byte MAX_TRIES = 5;

    public static void main(String[] args) {
        startScanner();
    }

    protected static double[] taxCalculate(int revenue) {
        double[] result = new double[2];
        if (revenue <= 10_000) {
            result[0] = FIRST_LVL_TAXES;
            result[1] = revenue * (FIRST_LVL_TAXES / 100);
        } else if (revenue <= 25_000) {
            result[0] = SECOND_LVL_TAXES;
            result[1] = revenue * (SECOND_LVL_TAXES / 100);
        } else {
            result[0] = THIRD_LVL_TAXES;
            result[1] = revenue * (THIRD_LVL_TAXES / 100);
        }
        return result;
    }

    private static Scanner scannerState() {
        return new Scanner(System.in);
    }

    private static void startScanner() {
        Scanner scanner = scannerState();
        System.out.println("Please, enter your revenue: ");
        int revenueValue = scanner.nextInt();

        if (revenueValue < 0 && MAX_TRIES > 1) {
            System.out.println("Revenue can not be less, than 1. Please, try again.");
            MAX_TRIES--;
            startScanner();
            return;
        } else if (MAX_TRIES <= 1) {
            System.out.println("Revenue can not be less, than 1. You've done 5 tries! That's enough. I'm quit!");
            return;
        }

        double[] calculatedTax = taxCalculate(revenueValue);
        System.out.printf("Taxes on your revenue with percentage %.2f", calculatedTax[0]);
        System.out.printf(" is %.2f", calculatedTax[1]);

    }
}
