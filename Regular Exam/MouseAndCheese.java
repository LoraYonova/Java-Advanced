package MouseAndCheese;

import java.util.Scanner;

public class MouseAndCheese {
    static int startRow = 0;
    static int startCol = 0;
    static int cheese = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("M")) {
                startRow = i;
                startCol = input.indexOf("M");
            }
        }

        boolean mouseGoesOut = false;
        String command = scan.nextLine();
        while (!command.equals("end")) {

            if (command.equals("up")) {
                mouseGoesOut = move(matrix, startRow - 1, startCol, command);
            } else if (command.equals("down")) {
                mouseGoesOut = move(matrix, startRow + 1, startCol, command);
            } else if (command.equals("left")) {
                mouseGoesOut = move(matrix, startRow, startCol - 1, command);
            } else if (command.equals("right")) {
                mouseGoesOut = move(matrix, startRow, startCol + 1, command);

            }
            if (mouseGoesOut) {
                break;
            }


            command = scan.nextLine();

        }
        if (mouseGoesOut) {
            System.out.println("Where is the mouse?");
        }
        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
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
        matrix[startRow][startCol] = '-';
        if (indexOutOfBounds(matrix, newRow, newCol)) {
            if (matrix[newRow][newCol] == 'c') {
                cheese++;
            } else if (matrix[newRow][newCol] == 'B') {
                matrix[newRow][newCol] = '-';
                if (command.equals("up")) {
                    newRow = newRow - 1;

                } else if (command.equals("down")) {
                    newRow = newRow + 1;

                } else if (command.equals("left")) {
                    newCol = newCol - 1;

                } else if (command.equals("right")) {
                    newCol = newCol + 1;
                }
                if (matrix[newRow][newCol] == 'c') {
                    cheese++;
                }


            }
            matrix[newRow][newCol] = 'M';
            startRow = newRow;
            startCol = newCol;

            return false;
        }
        startRow = newRow;
        startCol = newCol;
        return true;


    }

    private static boolean indexOutOfBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;

    }
}
