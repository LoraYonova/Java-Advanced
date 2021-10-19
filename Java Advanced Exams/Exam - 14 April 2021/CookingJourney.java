package MockExams;

import java.util.Scanner;

public class CookingJourney {
    static int startRow;
    static int startCol;
    static int money;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("S")) {
                startRow = i;
                startCol = input.indexOf("S");
            }
        }

        boolean isOutOfPastryShop = true;


        while (money < 50 && isOutOfPastryShop) {

            String command = scan.nextLine();

            if (command.equals("up")) {
                isOutOfPastryShop = move(matrix, startRow - 1, startCol);
            } else if (command.equals("down")) {
                isOutOfPastryShop = move(matrix, startRow + 1, startCol);

            } else if (command.equals("left")) {
                isOutOfPastryShop = move(matrix, startRow, startCol - 1);

            } else if (command.equals("right")) {
                isOutOfPastryShop = move(matrix, startRow, startCol + 1);
            }



        }

        if (!isOutOfPastryShop) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);

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


        matrix[startRow][startCol] = '-';
        if (indexOutOfBounds(matrix.length, newRow, newCol)) {
            char symbol = matrix[newRow][newCol];

            if (matrix[newRow][newCol] == 'P') {
                matrix[newRow][newCol] = '-';
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if(matrix[i][j] == 'P') {
                            newRow = i;
                            newCol = j;

                        }
                    }
                }
            } else if (Character.isDigit(symbol)) {
                money += symbol - '0';
            }

        } else {
            return false;
        }
        matrix[newRow][newCol] = 'S';

        startRow = newRow;
        startCol = newCol;
        return true;

    }

    private static boolean indexOutOfBounds(int length, int row, int col) {
        return row >= 0 && row < length && col >= 0 && col <
                length;
    }
}
