package MockExams;

import java.util.Scanner;

public class Snake {
    static int startRow = 0;
    static int startCol = 0;
    static int food = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                startRow = i;
                startCol = line.indexOf("S");
            }

        }
        boolean snakeComesOut = false;

        while (food < 10 && !snakeComesOut) {
            String command = scan.nextLine();

            if (command.equals("up")) {
                snakeComesOut = move(matrix,startRow - 1,startCol);

            } else if (command.equals("down")) {
                snakeComesOut = move(matrix,startRow + 1,startCol);

            } else if (command.equals("left")) {
              snakeComesOut = move(matrix,startRow,startCol - 1);

            } else if (command.equals("right")) {
                snakeComesOut = move(matrix,startRow,startCol + 1);
            }

        }

        if (snakeComesOut) {
            System.out.println("Game over!");
        }
        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);

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

    private static boolean move(char[][] matrix, int newRow, int newCol) {
        matrix[startRow][startCol] = '.';

        if (indexOutOfBounds(matrix.length,newRow,newCol)) {
            if (matrix[newRow][newCol] == '*') {
                food++;

            } else if (matrix[newRow][newCol] == 'B') {
                matrix[newRow][newCol] = '.';
                findSecondB(matrix);
                matrix[startRow][startCol] = 'S';
                return false;

            }
            matrix[newRow][newCol] = 'S';
            startRow = newRow;
            startCol = newCol;
            return false;
        }
        return true;
    }

    private static void findSecondB(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
    }

    private static boolean indexOutOfBounds(int length, int row, int col) {
        return row >= 0 && row < length && col >= 0 && col < length;
    }
}
