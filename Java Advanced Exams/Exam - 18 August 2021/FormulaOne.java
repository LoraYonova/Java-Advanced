package MockExams;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int countOfCommand = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];

        int[] position = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("P")) {
                position[0] = i;
                position[1] = input.indexOf("P");
            }

        }
        boolean playerWon = false;
        while (countOfCommand-- > 0 && !playerWon) {
            String input = scan.nextLine();

            if (input.equals("up")) {
                playerWon = move(position, matrix, -1, 0);

            } else if (input.equals("down")) {
                playerWon = move(position, matrix, +1, 0);
            } else if (input.equals("left")) {
                playerWon = move(position, matrix, 0, -1);
            } else if (input.equals("right")) {
                playerWon = move(position, matrix, 0, +1);
            }


        }
        if (playerWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean move(int[] position, char[][] matrix, int rowModification, int colModification) {


        int row = position[0];
        int col = position[1];
        int newRow = ensureIndexIsInBounds(row + rowModification, matrix.length);
        int newCol = ensureIndexIsInBounds(col + colModification, matrix.length);

        boolean hasWon = false;

        if (matrix[newRow][newCol] == 'B') {
            newRow = ensureIndexIsInBounds(newRow + rowModification, matrix.length);
            newCol = ensureIndexIsInBounds(newCol + colModification, matrix.length);

        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;
        }

        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        }
        matrix[row][col] = '.';
        matrix[newRow][newCol] = 'P';
        position[0] = newRow;
        position[1] = newCol;
        return hasWon;

    }

    private static int ensureIndexIsInBounds(int index, int bounds) {
        if (index < 0) {
            index = bounds - 1;
        } else if (index >= bounds) {
            index = 0;
        }
        return index;

    }


}
