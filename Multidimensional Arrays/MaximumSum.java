package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] elements = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = elements[0];
        int cols = elements[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int bestSum = Integer.MIN_VALUE;
        int[] bestVector = new int[2];

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int[] start = new int[]{i, j};
                if (findSum(start, matrix) > bestSum) {
                    bestSum = findSum(start, matrix);
                    bestVector = start;
                }
            }
        }
        System.out.printf("Sum = %d%n" , bestSum);
        printMatrix(bestVector, matrix);

    }

    private static void printMatrix(int[] bestVector, int [][] matrix) {

        for (int i = bestVector[0]; i < bestVector[0] + 3; i++) {
            for (int j = bestVector[1]; j < bestVector[1] + 3; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int findSum(int[] start, int[][] matrix) {
        int sum = 0;
        for (int i = start[0]; i < start[0] + 3; i++) {
            for (int j = start[1]; j < start[1] + 3; j++) {
                sum += matrix[i][j];
            }

        }


        return sum;
    }
}
