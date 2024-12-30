package com.gmail.mpylypenko.homeworks.hw51.taxes;

import java.util.Scanner;

public class TaxOnRevenue {
    private static byte maxTries = 5;
    private static Scanner scannerState = new Scanner(System.in);

    public static void main(String[] args) {
        startScanner();
    }

    protected static double[] getPercentageAndCalculatedTax(int revenue) {
        double lowTaxRate = 2.5;
        double middleTaxRate = 4.3;
        double highTaxRate = 6.7;
        double[] result = new double[2];
        if (revenue <= 10_000) {
            result[0] = lowTaxRate;
            result[1] = taxCalculate(revenue, lowTaxRate);
        } else if (revenue <= 25_000) {
            result[0] = middleTaxRate;
            result[1] = taxCalculate(revenue, middleTaxRate);
        } else {
            result[0] = highTaxRate;
            result[1] = taxCalculate(revenue, highTaxRate);
        }
        return result;
    }

    protected static double taxCalculate(int revenue, double percentage) {
        return revenue * (percentage / 100);
    }

    private static void startScanner() {
        System.out.println("Please, enter your revenue: ");
        int revenueValue = scannerState.nextInt();

        if (revenueValue < 0 && maxTries > 1) {
            System.out.println("Revenue can not be less, than 1. Please, try again.");
            maxTries--;
            startScanner();
            return;
        } else if (maxTries <= 1) {
            System.out.println("Revenue can not be less, than 1. You've done 5 tries! That's enough. I'm quit!");
            return;
        }

        double[] calculatedTaxAndPercentage = getPercentageAndCalculatedTax(revenueValue);
        System.out.printf("Tax on your revenue with percentage %.2f", calculatedTaxAndPercentage[0]);
        System.out.printf(" is %.2f", calculatedTaxAndPercentage[1]);

    }
}
