package com.gmail.mpylypenko.tasks.t01;

import java.util.Random;
import java.util.Scanner;

public class Transposition {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        printMatrix(matrix);
        if (!isMatrixValidForTransposition(matrix)) {
            System.out.println("Matrix is invalid. Do nothing.");
            return;
        }
        transposeMatrix(matrix);
        System.out.print("Transposed ");
        printMatrix(matrix);
    }

    private static boolean isMatrixValidForTransposition(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    private static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int savedValue = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = savedValue;
            }
        }
    }

    private static int[][] createMatrix() {
        int axisX = askClientEnterInteger("Please, enter amount of a rows for matrix: ");
        int axisY = askClientEnterInteger("Please, enter amount of a columns for matrix: ");
        int maxValueOfMatrix = askClientEnterInteger("Please, enter max value for matrix: ");
        return generateMatrix(axisX, axisY, maxValueOfMatrix);
    }

    private static int askClientEnterInteger(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
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

    private static void printMatrix(int[][] matrix) {
        System.out.println("Matrix with size " + matrix.length + "x" + matrix[0].length);
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
