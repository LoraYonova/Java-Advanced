package MultidimentionalArrays;


import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        int rowsAndCols = Integer.parseInt(input[0]);
        String patterns = input[1];

        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        if (patterns.equals("A")) {
            fillMatrixPatternA(matrix, rowsAndCols);


        } else if (patterns.equals("B")) {
            fillMatrixPatternB(matrix,rowsAndCols);
        }

    }

    private static void fillMatrixPatternB(int[][] matrix, int rowsAndCols) {
        int numbers = 1;
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                if (i % 2 == 0) {
                    matrix[j][i] += numbers;
                } else {
                    matrix[matrix.length - 1 - j][i] += numbers;


                }
                numbers++;

            }
        }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }



    }

    public static void fillMatrixPatternA(int[][] matrix, int rowsAndCols) {
        int numbers = 1;
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {

                matrix[j][i] += numbers;
                numbers++;

            }


        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }



    }
}
