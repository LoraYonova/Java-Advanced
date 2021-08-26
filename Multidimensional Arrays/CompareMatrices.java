package MultidimentionalArrays;


import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] firstArray = readMatrices(scan);
        int[][] secondArray = readMatrices(scan);


        if (matricesAreEqual(firstArray, secondArray)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static int[][] readMatrices(Scanner scan) {

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            array[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();


        }
        return array;

    }

    private static boolean matricesAreEqual(int[][] firstArray, int[][] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i].length != secondArray[i].length) {
                return false;
            }
            for (int j = 0; j < firstArray[i].length; j++) {
                if (firstArray[i][j] != secondArray[i][j]) {
                    return false;
                }
            }

        }
        return true;
    }
}
