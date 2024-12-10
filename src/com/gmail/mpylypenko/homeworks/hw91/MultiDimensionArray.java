package com.gmail.mpylypenko.homeworks.hw91;

import java.util.Random;
import java.util.Scanner;

public class MultiDimensionArray {
    public static void main(String[] args) {
        int axisX = askClient("Please, enter amount of a rows for matrix: ");
        int axisY = askClient("Please, enter amount of a columns for matrix: ");
        int maxValueOfMatrix = askClient("Please, enter max value for matrix: ");

        int[][] matrix = generateMatrix(axisX, axisY, maxValueOfMatrix);
        printMatrix(matrix);

        int sumEvenValues = sumsValuesRowsByType(matrix, 0);
        int sumOddValues = sumsValuesRowsByType(matrix, 1);

        printInfoWithDivider("Sum of all values in each even rows is " + sumEvenValues);
        printInfo("Sum of all values in each odd rows is " + sumOddValues);

        int multiplyEvenValues = multiplyValuesInColumnsByType(matrix, 0);
        int multiplyOddValues = multiplyValuesInColumnsByType(matrix, 1);

        printInfoWithDivider("Multiply of all values in each even column is " + multiplyEvenValues);
        printInfo("Multiply of all values in each odd column is " + multiplyOddValues);

        boolean isMagicalSquare = checkOnMagicMatrixAndPrintResult(matrix);
        if (isMagicalSquare) {
            printInfo("Matrix is a Magical square.");
        } else {
            printInfo("Matrix is not a Magical square.");
        }
    }

    private static int[][] generateMatrix(int axisX, int axisY, int maxValue) {
        int[][] matrix = new int[axisX][axisY];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(1, maxValue + 1);
            }
        }
        return matrix;
    }

    private static int askClient(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Matrix with size " + matrix.length + "x" + matrix[0].length);
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    private static int sumsValuesRowsByType(int[][] matrix, int startIndex) {
        int sum = 0;
        for (int i = startIndex; i < matrix.length; i += 2) {
            for (int cell : matrix[i]) {
                sum += cell;
            }
        }
        return sum;
    }

    private static int multiplyValuesInColumnsByType(int[][] matrix, int startIndex) {
        int multiply = 0;
        for (int[] row : matrix) {
            for (int j = startIndex; j < row.length; j += 2) {
                if (multiply == 0) {
                    multiply = row[j];
                } else {
                    multiply = multiply * row[j];
                }
            }
        }
        return multiply;
    }

    private static boolean checkOnMagicMatrixAndPrintResult(int[][] matrix) {
        printInfoWithDivider("");
        if (matrix.length != matrix[0].length) {
            return false;
        }

        int totalSum = 0;
        int firstSum = 0;

        /*Sum values of row cells*/
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                totalSum += matrix[i][j];
            }
            /*Defined first value of sum; other must be equal*/
            if (firstSum == 0) {
                firstSum = totalSum;
            }
            if (i == matrix.length - 1 && firstSum != totalSum / matrix.length) {
                printInfoWithDivider("Sums of each row is not equal. Expected average from all rows: " + firstSum + "; received: " + totalSum / matrix.length);
                return false;
            }

        }

        /*Sum values of column cells*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                totalSum += matrix[j][i];
            }
            if (i == matrix.length - 1 && firstSum != totalSum / (matrix.length + matrix[i].length)) {
                printInfoWithDivider("Sums of each column is not equal. Expected from all columns: " + firstSum + "; received: " + totalSum / (matrix.length + matrix[i].length));
                return false;
            }
        }

        /*Sum values of diagonals cells*/
        for (int i = 0; i < matrix.length; i++) {
            totalSum += matrix[i][i];
            totalSum += matrix[matrix.length - 1 - i][i];
            if (i == matrix.length - 1) {
                if (firstSum != totalSum / (matrix.length + matrix[i].length + 2)) {
                    printInfoWithDivider("Sums of each diagonal is not equal. Expected from all diagonals: " + firstSum + "; received: " + totalSum / (matrix.length + matrix[i].length + 2));
                    return false;
                }
            }
        }
        return true;
    }

    private static void printInfoWithDivider(String text) {
        System.out.println("<--==========================-->");
        System.out.println(text);
    }

    private static void printInfo(String text) {
        System.out.println(text);
    }
}
