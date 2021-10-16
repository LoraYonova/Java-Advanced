package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int [][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
          matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                  .mapToInt(Integer::parseInt)
                  .toArray();
        }
        int primaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j) {
                    primaryDiagonal += matrix[i][j];
                }
            }
        }
        int secondDiagonal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1 - i) {
                    secondDiagonal += matrix[i][j];
                }
            }
        }

        int sumDifference = Math.abs(primaryDiagonal - secondDiagonal);

        System.out.println(sumDifference);


    }
}
