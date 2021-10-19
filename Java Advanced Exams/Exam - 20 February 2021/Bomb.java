package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    static int startRow = 0;
    static int startCol = 0;
    static int countBomb = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        ArrayDeque<String> commands = Arrays.stream(scan.nextLine().split(","))
                .collect(Collectors.toCollection(ArrayDeque::new));


        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine().replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();
            if (input.contains("s")) {
                startRow = i;
                startCol = input.indexOf("s");
            }

        }
       checkCountOfBombs(matrix);

        boolean endOfGame = false;
        while (!commands.isEmpty() && countBomb > 0) {
            String movePosition = commands.poll();

            if (movePosition.equals("up")) {
                endOfGame = move(matrix, startRow - 1, startCol);

            } else if (movePosition.equals("down")) {
                endOfGame = move(matrix, startRow + 1, startCol);

            } else if (movePosition.equals("left")) {
                endOfGame = move(matrix, startRow, startCol - 1);

            } else if (movePosition.equals("right")) {
                endOfGame = move(matrix, startRow, startCol + 1);
            }

            if (endOfGame) {
                System.out.println("END! " + countBomb + " bombs left on the field");
                break;
            }

        }

        if (countBomb == 0) {
            System.out.println("Congratulations! You found all bombs!");
        }
        if (countBomb > 0 && !endOfGame) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countBomb, startRow, startCol);
        }


    }

    private static void checkCountOfBombs(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    countBomb++;
                }
            }
        }


    }

    private static boolean move(char[][] matrix, int newRow, int newCol) {

        if (isIndexOutOfBounds(matrix, newRow, newCol)) {
            matrix[startRow][startCol] = '+';

            if (matrix[newRow][newCol] == 'B') {
                countBomb--;
                System.out.println("You found a bomb!");

            } else if (matrix[newRow][newCol] == 'e') {
                matrix[newRow][newCol] = 's';
                startRow = newRow;
                startCol = newCol;
                return true;
            }
            matrix[newRow][newCol] = 's';
            startRow = newRow;
            startCol = newCol;

        }
        return false;
    }

    private static boolean isIndexOutOfBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

}
