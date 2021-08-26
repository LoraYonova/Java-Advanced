package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = elements[0];
        int cols = elements[1];

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int number = Integer.parseInt(scan.nextLine());

     boolean notFound = findNumberInMatrix(matrix, number);
        if (!notFound) {
            System.out.println("not found");
        }

    }

    private static boolean findNumberInMatrix(int[][] matrix, int number) {
        boolean notFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    notFound = true;
                    System.out.println(i + " " + j);
                }
            }
        }

                return notFound;

    }
}
