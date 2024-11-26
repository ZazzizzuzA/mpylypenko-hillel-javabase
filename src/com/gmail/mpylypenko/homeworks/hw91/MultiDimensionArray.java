package com.gmail.mpylypenko.homeworks.hw91;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MultiDimensionArray {
    public static void main(String[] args) {
        int axisX = askClient("Please, enter amount of a rows for matrix: ");
        int axisY = askClient("Please, enter amount of a columns for matrix: ");
        int maxValueOfMatrix = askClient("Please, enter max value for matrix: ");

        int[][] matrix = generateMatrix(axisX, axisY, maxValueOfMatrix);
        printMatrix(matrix);

        int[] arraySumsEvenAndOddValues = sumsValuesRowsByType(matrix);

        printInfo("Sum of all values in each even rows is " + arraySumsEvenAndOddValues[0], true);
        printInfo("Sum of all values in each odd rows is " + arraySumsEvenAndOddValues[1], false);
        int[] arrayMultipliesEvenAndOddValues = multiplyValuesInColumnsByType(matrix);
        printInfo("Multiply of all values in each even column is " + arrayMultipliesEvenAndOddValues[0], true);
        printInfo("Multiply of all values in each odd column is " + arrayMultipliesEvenAndOddValues[1], false);

        checkOnMagicMatrixAndPrintResult(matrix);
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
        for (int[] rows : matrix) {
            for (int columns : rows) {
                System.out.print(columns + "\t");
            }
            System.out.println();
        }
    }

    private static int[] sumsValuesRowsByType(int[][] matrix) {
        int[] arraySumsEvenAndOddValues = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int cell : matrix[i]) {
                arraySumsEvenAndOddValues[i % 2] += cell;
            }
        }
        return arraySumsEvenAndOddValues;
    }

    private static int[] multiplyValuesInColumnsByType(int[][] matrix) {
        int[] multiplyEvenAndOddValuesOfRow = new int[2];
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                int indexByType = j % 2;
                if (multiplyEvenAndOddValuesOfRow[indexByType] == 0) {
                    multiplyEvenAndOddValuesOfRow[indexByType] = row[j];
                } else {
                    multiplyEvenAndOddValuesOfRow[indexByType] = multiplyEvenAndOddValuesOfRow[indexByType] * row[j];
                }
            }
        }
        return multiplyEvenAndOddValuesOfRow;
    }

    private static void checkOnMagicMatrixAndPrintResult(int[][] matrix) {
        printInfo("", true);
        if (matrix.length != matrix[0].length) {
            printInfo("Matrix is not a Magical square.", false);
            return;
        }

        /* Second try */

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
                printInfo("Sums of each row is not equal. Expected average from all rows: " + firstSum + "; received: " + totalSum / matrix.length, true);
                printInfo("Matrix is not a Magical square.", false);
                return;
            }

        }

        /*Sum values of column cells*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                totalSum += matrix[j][i];
            }
            if (i == matrix.length - 1 && firstSum != totalSum / (matrix.length + matrix[i].length)) {
                printInfo("Sums of each column is not equal. Expected from all columns: " + firstSum + "; received: " + totalSum / (matrix.length + matrix[i].length), true);
                printInfo("Matrix is not a Magical square.", false);
                return;
            }

        }

        /*Sum values of diagonals cells*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (i == j) {
                    totalSum += matrix[i][j];
                }
                if (matrix[i].length - 1 - i == j) {
                    totalSum += matrix[i][j];
                }
            }
            if (i == matrix.length - 1) {
                if (firstSum != totalSum / (matrix.length + matrix[i].length + 2)) {
                    printInfo("Sums of each diagonal is not equal. Expected from all diagonals: " + firstSum + "; received: " + totalSum / (matrix.length + matrix[i].length + 2), true);
                    printInfo("Matrix is not a Magical square.", false);
                    return;
                }
            }
        }

        /* First try */

//        int[] sumValuesOfEachRow = new int[matrix.length];
//        int[] sumValuesOfEachColumn = new int[matrix[0].length];
//        int[] sumValuesOfEachDiagonals = new int[2];
//        int firstSumForCheck = 0;

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                sumValuesOfEachRow[i] += matrix[i][j];
//                sumValuesOfEachColumn[j] += matrix[i][j];
//                if (i == j) {
//                    sumValuesOfEachDiagonals[0] += matrix[i][j];
//                }
//                if (matrix[i].length - 1 - i == j) {
//                    sumValuesOfEachDiagonals[1] += matrix[i][j];
//                }
//
//                if (j == matrix[i].length - 1 && i == 0) {
//                    firstSumForCheck = sumValuesOfEachRow[i];
//                }
//
//                if (j == matrix[i].length - 1 && i == matrix.length - 1) {
//                    if (sumValuesOfEachRow[i] != firstSumForCheck || sumValuesOfEachColumn[j] != firstSumForCheck || sumValuesOfEachDiagonals[0] != firstSumForCheck || sumValuesOfEachDiagonals[1] != firstSumForCheck) {
//                        printInfo("Sums of each row is " + sumValuesOfEachRow[0], true);
//                        printInfo("Sums of each column is " + sumValuesOfEachColumn[0], false);
//                        printInfo("Sums of each diagonals is " + sumValuesOfEachDiagonals[0], false);
//                        printInfo("Matrix is not a Magical square.", false);
//                        return;
//                    }
//                }
//            }
//        }
//        printInfo("Sums of each row is " + Arrays.toString(sumValuesOfEachRow), true);
//        printInfo("Sums of each column is " + Arrays.toString(sumValuesOfEachColumn), false);
//        printInfo("Sums of each diagonals is " + Arrays.toString(sumValuesOfEachDiagonals), false);
        printInfo("Matrix is a Magical square.", false);
    }

    private static void printInfo(String text, boolean needDivider) {
        if (needDivider) {
            System.out.println("<--==========================-->");
        }
        System.out.println(text);
    }
}
