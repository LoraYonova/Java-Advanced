package MultidimentionalArrays;


import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dimensions = scan.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);


        String[][] matrix = new String[rows][cols];
                readingMatrix(scan, rows, matrix);

        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            boolean invalid = false;

            String command = commands[0];
            if (command.equals("swap") && commands.length == 5) {
                int row1 = Integer.parseInt(commands[1]);  // 0
                int col1 = Integer.parseInt(commands[2]);  // 0
                int row2 = Integer.parseInt(commands[3]);  // 1
                int col2 = Integer.parseInt(commands[4]);  // 1

                if (validationsIndex(rows, cols, row1, col1, row2, col2)) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    printMatrix(matrix);

                } else {
                    invalid = true;
                }
            } else {
                invalid = true;

            }

            if (invalid) {
                System.out.println("Invalid input!");
            }

            input = scan.nextLine();
        }

    }

    private static boolean validationsIndex(int rows, int cols, int row1, int col1, int row2, int col2) {
        return (row1 >= 0 && row1 < rows) && (row2 >= 0 && row2 < rows) && (col1 >= 0 && col1 < cols) && (col2 >= 0 && col2 < cols);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }


    private static String[][] readingMatrix(Scanner scan, int rows, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
}
