package MultidimentionalArrays;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char character = 'a';
        int row = scan.nextInt();
        int col = scan.nextInt();
        String[][] matrix = new String[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = "" + character + (char) (character + c) + character + " ";
            }
            character++;
        }
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }
}
