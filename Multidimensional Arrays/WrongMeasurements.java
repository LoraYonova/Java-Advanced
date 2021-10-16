package MultidimentionalArrays;


import java.util.Arrays;

import java.util.Scanner;

public class WrongMeasurements {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = readingMatrix(rows, scan);
        int [][] newMatrix = fillMatrix(matrix);


        int row = scan.nextInt();
        int col = scan.nextInt();

        //fineWrongValue(row, col, matrix, rows);

        int wrongNumber = fineWrongValue(row, col, matrix);

        changeWrongNumber(matrix, wrongNumber, newMatrix);




        printMatrix(newMatrix);


    }

    private static int[][] fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
        return matrix;
    }


    private static void printMatrix(int[][] newMatrix) {
        for (int[] ints : newMatrix) {
            for (int arr : ints) {
                System.out.print(arr + " ");
            }
            System.out.println();
        }
    }

    private static int fineWrongValue(int row, int col, int[][] matrix) {
        int wrongNumber = 0;
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == row && j == col) {
                    wrongNumber = matrix[i][j];
                    isFound = true;
                    break;


                }
            }
            if (isFound) {
                break;
            }
        }
        return wrongNumber;
    }

    private static int[][] changeWrongNumber(int[][] matrix, int wrongNumber, int[][] newMatrix) {


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int sum = 0;

                if (matrix[row][col] == wrongNumber) {


                    if (col - 1 >= 0 && matrix[row][col - 1] != wrongNumber) {
                        sum += matrix[row][col - 1];

                    }
                    if (col + 1 <= matrix.length && matrix[row][col + 1] != wrongNumber) {

                        sum += matrix[row][col + 1];

                    }

                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumber) {

                        sum += matrix[row - 1][col];

                    }
                    if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber) {

                        sum += matrix[row + 1][col];

                    }

                    newMatrix[row][col] = sum;

                }
            }
        }
        return newMatrix;
    }


    private static int[][] readingMatrix(int rows, Scanner scan) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
