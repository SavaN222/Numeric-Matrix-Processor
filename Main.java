package com.sava;

import java.util.Scanner;

public class Main {
    public static double[][] firstMatrix;
    public static double[][] secondMatrix;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            printMenu();
            System.out.print("Your choice: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    mulitplyByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 4:
                    transposeMatrix();
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }

    private static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" "); // new line
        }
        System.out.println(" "); // new line
    }

    public static void transposeMatrix() {
        System.out.print("\n1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n");
        System.out.print("Your choice: ");
        int num = sc.nextInt();
        System.out.print("Enter matrix size: ");
        double[][] matrix = new double[sc.nextInt()][sc.nextInt()];
        System.out.print("Enter matrix: \n");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = sc.nextDouble();
            }
        }
        System.out.println("The result is:");

        switch (num) {
            case 1:
                mainDiagonal(matrix);
                break;
            case 2:
                sideDiagonal(matrix);
                break;
            case 3:
                verticalLine(matrix);
                break;
            case 4:
                horizontalLine(matrix);
                break;
        }

    }

    private static void mainDiagonal(double[][] matrix) {
        double[][] diagonalMatrix = new double[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                diagonalMatrix[row][col] = matrix[col][row];
            }
        }
        printMatrix(diagonalMatrix);
    }

    private static void sideDiagonal(double[][] matrix) {
        double[][] diagonalMatrix = new double[matrix.length][matrix[0].length];
        int rowLen = matrix.length-1;
        int colLen = matrix[0].length-1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                diagonalMatrix[rowLen-j][colLen-i] = matrix[i][j];
            }
        }

       printMatrix(diagonalMatrix);
    }

    private static void verticalLine(double[][] matrix) {
        double[][] verticalMatrix = new double[matrix.length][matrix[0].length];
        int colLen = matrix[0].length-1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                verticalMatrix[i][colLen-j] = matrix[i][j];
            }
        }

        printMatrix(verticalMatrix);
    }

    private static void horizontalLine(double[][] matrix) {
        double[][] horizontalMatrix = new double[matrix.length][matrix[0].length];
        int rowLen = matrix.length-1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                horizontalMatrix[rowLen - i][j] = matrix[i][j];
            }
        }

        printMatrix(horizontalMatrix);
    }

    private static void printMenu() {
        System.out.print("1. Add Matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "0. Exit\n");
    }

    public static void multiplyMatrices() {
        createMatrices();
        double result = 0;
        System.out.println("The result is:");
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                for (int i = 0; i < firstMatrix[row].length; i++) {
                    result += (firstMatrix[row][i] * secondMatrix[i][col]);
                }
                System.out.print(result + " ");
                result = 0;
            }
            System.out.println(" "); // new line
        }
        System.out.println(" "); // new line
    }

    public static void addMatrices() {
        createMatrices();
        if (firstMatrix.length != secondMatrix.length && firstMatrix[0].length != secondMatrix[0].length) {
            System.out.println("The operation cannot be performed.");
            System.out.println(" "); // new line
            return;
        }
        System.out.println("The result is:");
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                double result = firstMatrix[row][col] + secondMatrix[row][col];
                System.out.print(result + " ");
            }
            System.out.println(" "); // new line
        }
        System.out.println(" "); // new line
    }

    public static void mulitplyByConstant() {
        System.out.print("Enter size of matrix: ");
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        double[][] matrix = new double[row1][col1];

        System.out.println("Enter matrix: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = sc.nextFloat();
            }
        }
        System.out.println("Enter constant: ");
        double constant = sc.nextFloat();
        System.out.println("The result is: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                double result = constant * matrix[row][col];
                System.out.print(result + " ");
            }
            System.out.println(" "); // new line
        }
        System.out.println(" "); // new line
    }

    private static void createMatrices() {
        System.out.print("Enter size of first matrix: ");
        firstMatrix = new double[sc.nextInt()][sc.nextInt()];
        System.out.println("Enter first matrix:");
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                firstMatrix[row][col] = sc.nextFloat();
            }
        }
        System.out.print("Enter size of second matrix:");
        secondMatrix = new double[sc.nextInt()][sc.nextInt()];
        System.out.println("Enter second matrix:");
        for (int row = 0; row < secondMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                secondMatrix[row][col] = sc.nextFloat();
            }
        }
    }
}