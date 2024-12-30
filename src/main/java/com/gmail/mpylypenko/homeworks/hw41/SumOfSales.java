package com.gmail.mpylypenko.homeworks.hw41;

public class SumOfSales {
    private static final String CURRENCY = "EUR";
    private static int numberOrder = 1;

    public static void main(String[] args) {
        String product = "smartphone";
        byte totalDays = 10;
        double totalSumSales = 12097.97;
        double salesPerDay = roundToTwoSigns(totalSumSales / totalDays);
        printStats(product, totalDays, totalSumSales, salesPerDay);

        product = "laptop";
        totalDays = 13;
        totalSumSales = 26_337.98;
        salesPerDay = roundToTwoSigns(totalSumSales / totalDays);
        printStats(product, totalDays, totalSumSales, salesPerDay);

        product = "Monitor";
        totalDays = 7;
        totalSumSales = 994.57;
        salesPerDay = roundToTwoSigns(totalSumSales / totalDays);
        printStats(product, totalDays, totalSumSales, salesPerDay);

        product = "Pen";
        totalDays = 2;
        totalSumSales = 5;
        salesPerDay = roundToTwoSigns(totalSumSales / totalDays);
        printStats(product, totalDays, totalSumSales, salesPerDay);
    }

    private static double roundToTwoSigns(double value) {
        return Math.floor(value * 100) / 100;
    }

    public static void printStats(String product, byte totalDays, double totalSales, double salesPerDay) {
        System.out.println("Order No " + numberOrder++ + " Product: " + product);
        System.out.print("total sales for " + totalDays + " days is " + CURRENCY);
        System.out.printf(" %.2f\n", totalSales);
        System.out.print("sales by day is " + CURRENCY);
        System.out.printf(" %.2f\n", salesPerDay);
        System.out.println("================================================");
    }
}
