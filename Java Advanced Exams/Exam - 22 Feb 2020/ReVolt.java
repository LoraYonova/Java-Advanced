package MockExams;

import java.util.Scanner;

public class ReVolt {
    static int startRow = 0;
    static int startCol = 0;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int commands = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("f")) {
                startRow = i;
                startCol = line.indexOf("f");
            }
        }

        boolean isFinished = false;
        while (commands-- > 0 && !isFinished) {

            String command = scan.nextLine();

            if (command.equals("up")) {
                isFinished = move(matrix, -1, 0);
            } else if (command.equals("down")) {
                isFinished = move(matrix, +1, 0);

            } else if (command.equals("left")) {
                isFinished = move(matrix, 0, -1);

            } else if (command.equals("right")) {
                isFinished = move(matrix, 0, +1);
            }

        }

        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean move(char[][] matrix, int rowModification, int colModification) {
        int newRow = checkTheIndex(startRow + rowModification, matrix.length);
        int newCol = checkTheIndex(startCol + colModification, matrix.length);
        matrix[startRow][startCol] = '-';
        if (matrix[newRow][newCol] == 'B') {

            newRow = checkTheIndex(newRow + rowModification, matrix.length);
            newCol = checkTheIndex(newCol + colModification, matrix.length);

            if (matrix[newRow][newCol] == 'F') {
                matrix[newRow][newCol] = 'f';
                return true;
            }
            matrix[newRow][newCol] = 'f';

        } else if (matrix[newRow][newCol] == 'T') {
            matrix[startRow][startCol] = 'f';
            return false;

        } else if (matrix[newRow][newCol] == 'F') {
            matrix[newRow][newCol] = 'f';
            return true;
        } else {
            matrix[newRow][newCol] = 'f';
        }

        startRow = newRow;
        startCol = newCol;
        return false;
    }

    private static int checkTheIndex(int index, int length) {

        if (index > length - 1) {
            index = 0;
        } else if (index < 0) {
            index = length - 1;
        }
        return index;
    }
}
