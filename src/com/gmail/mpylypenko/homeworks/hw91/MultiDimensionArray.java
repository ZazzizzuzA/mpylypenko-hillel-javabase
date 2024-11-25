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
        sumValuesRowsByTypeAndPrint(matrix, "odd");
        sumValuesRowsByTypeAndPrint(matrix, "even");

        multiplyValuesInColumnsAndPrint(matrix, "odd");
        multiplyValuesInColumnsAndPrint(matrix, "even");

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

    private static void sumValuesRowsByTypeAndPrint(int[][] matrix, String type) {
        System.out.print("Sum of all values in an " + type + " rows (row ");
        int sumValuesOfRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean check = type == "odd" ? i % 2 == 0 : i % 2 != 0;
            if (check) {
                continue;
            }
            System.out.print(i + " ");
            for (int columns : matrix[i]) {
                sumValuesOfRow += columns;
            }
        }
        System.out.print(") ");
        System.out.println("is " + sumValuesOfRow + ";");
    }

    private static void multiplyValuesInColumnsAndPrint(int[][] matrix, String type) {
        System.out.print("Multiply of all values in an " + type + " columns (column ");
        int multiplyValuesOfRow = 0;
        StringBuilder columns = new StringBuilder();
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                boolean check = type == "odd" ? j % 2 == 0 : j % 2 != 0;
                if (check) {
                    continue;
                }
                if (!columns.toString().contains("" + j)) {
                    columns.append(j).append(" ");
                }

                if (multiplyValuesOfRow == 0) {
                    multiplyValuesOfRow = row[j];
                } else {
                    multiplyValuesOfRow = multiplyValuesOfRow * row[j];
                }
            }
        }
        System.out.print(columns);
        System.out.print(") ");
        System.out.println("is " + multiplyValuesOfRow + ";");
    }

    private static void checkOnMagicMatrixAndPrintResult(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Matrix is not a Magical square.");
            return;
        }

        int[] sumValuesOfEachRow = new int[matrix.length];
        int[] sumValuesOfEachColumn = new int[matrix[0].length];
        int[] sumValuesOfEachDiagonals = new int[2];
        int firstSumForCheck = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumValuesOfEachRow[i] += matrix[i][j];
                sumValuesOfEachColumn[j] += matrix[i][j];
                if (i == j) {
                    sumValuesOfEachDiagonals[0] += matrix[i][j];
                }
                if (matrix[i].length - 1 - i == j) {
                    sumValuesOfEachDiagonals[1] += matrix[i][j];
                }

                if (j == matrix[i].length - 1 && i == 0) {
                    firstSumForCheck = sumValuesOfEachRow[i];
                }

                if (j == matrix[i].length - 1 && i == matrix.length - 1) {
                    if (sumValuesOfEachRow[i] != firstSumForCheck || sumValuesOfEachColumn[j] != firstSumForCheck || sumValuesOfEachDiagonals[0] != firstSumForCheck || sumValuesOfEachDiagonals[1] != firstSumForCheck) {
                        System.out.println("Sums of each row is " + Arrays.toString(sumValuesOfEachRow));
                        System.out.println("Sums of each column is " + Arrays.toString(sumValuesOfEachColumn));
                        System.out.println("Sums of each diagonals is " + Arrays.toString(sumValuesOfEachDiagonals));
                        System.out.println("Matrix is not a Magical square.");
                        return;
                    }
                }
            }
        }
        System.out.println("Sums of each row is " + Arrays.toString(sumValuesOfEachRow));
        System.out.println("Sums of each column is " + Arrays.toString(sumValuesOfEachColumn));
        System.out.println("Sums of each diagonals is " + Arrays.toString(sumValuesOfEachDiagonals));
        System.out.println("Matrix is a Magical square.");
    }
}
