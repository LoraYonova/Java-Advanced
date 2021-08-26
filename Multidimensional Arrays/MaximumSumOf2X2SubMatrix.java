package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] elements = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = elements[0];
        int cols = elements[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int bestSum = Integer.MIN_VALUE;

        int resultRow = 0;
        int resultCol = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sum > bestSum) {
                    bestSum = sum;
                    resultRow = i;
                    resultCol = j;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == resultRow && j == resultCol) {
                    System.out.println(matrix[i][j] + " " + matrix[i][j + 1]);
                    System.out.println(matrix[i + 1][j] + " " + matrix[i + 1][j + 1]);
                    System.out.println(bestSum);
                }
            }
        }


    }
}
