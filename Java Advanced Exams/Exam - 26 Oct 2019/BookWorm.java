package MockExams;


import java.util.Scanner;

public class BookWorm {
    static int startRow = 0;
    static int startCol = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder line = new StringBuilder(scan.nextLine());

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];


        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("P")) {
                startRow = i;
                startCol = input.indexOf("P");
            }
        }

        String command = scan.nextLine();

        while (!command.equals("end")) {


            if (command.equals("up")) {
                move(matrix, startRow - 1, startCol, line);

            } else if (command.equals("down")) {
                move(matrix, startRow + 1, startCol, line);

            } else if (command.equals("left")) {
                move(matrix, startRow , startCol - 1, line);

            } else if (command.equals("right")) {
                move(matrix, startRow, startCol + 1, line);
            }


            command = scan.nextLine();
        }
        System.out.println(line);
        printMatrix(matrix);


    }

    private static void move(char[][] matrix, int newRow, int newCol, StringBuilder line) {

        if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix.length) {

            matrix[startRow][startCol] = '-';
            if (Character.isAlphabetic(matrix[newRow][newCol])) {
                line.append(matrix[newRow][newCol]);
            }
            matrix[newRow][newCol] = 'P';
            startRow = newRow;
            startCol = newCol;
        } else {
            line.deleteCharAt(line.length() - 1);
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
