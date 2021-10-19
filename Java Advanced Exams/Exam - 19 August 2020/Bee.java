package MockExams;

import java.util.Scanner;

public class Bee {
    static int startRow = 0;
    static int startCol = 0;
    static int pollinatesFlowers = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];


        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();

            if (input.contains("B")) {
                startRow = i;
                startCol = input.indexOf("B");
            }
        }

        String command = scan.nextLine();
        boolean goesOut = false;

        while (!command.equals("End")) {

            if (command.equals("up")) {
                goesOut = move(matrix, startRow - 1, startCol, command);
            } else if (command.equals("down")) {
                goesOut = move(matrix, startRow + 1, startCol, command);

            } else if (command.equals("left")) {
                goesOut = move(matrix, startRow, startCol - 1, command);
            } else if (command.equals("right")) {
                goesOut = move(matrix, startRow, startCol + 1, command);
            }

            if (goesOut) {
                System.out.println("The bee got lost!");
                break;
            }

            command = scan.nextLine();
        }

        if (pollinatesFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatesFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatesFlowers);
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

    private static boolean move(char[][] matrix, int newRow, int newCol, String command) {
        matrix[startRow][startCol] = '.';
        if (IndexOutOfBounds(matrix.length, newRow, newCol)) {
            if (matrix[newRow][newCol] == 'O') {

                if (command.equals("up")) {
                    startRow = newRow - 1;
                    startCol = newCol;

                } else if (command.equals("down")) {
                    startRow = newRow + 1;
                    startCol = newCol;

                } else if (command.equals("left")) {
                    startRow = newRow;
                    startCol = newCol - 1;

                } else if (command.equals("right")) {
                    startRow = newRow;
                    startCol = newCol + 1;

                }
                matrix[newRow][newCol] = '.';
                if (matrix[startRow][startCol] == 'f') {
                    pollinatesFlowers++;
                }
                matrix[startRow][startCol] = 'B';

            } else if (matrix[newRow][newCol] == 'f') {
                matrix[newRow][newCol] = 'B';
                pollinatesFlowers++;
                startRow = newRow;
                startCol = newCol;

            } else {
                matrix[newRow][newCol] = 'B';
                startRow = newRow;
                startCol = newCol;

            }
            return false;

        }
        return true;


    }


    private static boolean IndexOutOfBounds(int length, int row, int col) {

        return row >= 0 && row < length && col >= 0 && col < length;

    }
}
