package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    static int startRow = 0;
    static int startCol = 0;
    static int food = 0;
    static int resultFood = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> commands = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine().replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();

            if (input.contains("s")) {
                startRow = i;
                startCol = input.indexOf("s");
            }
            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);
                if (symbol == 'f') {
                    food++;
                    resultFood++;
                }
            }
        }

        boolean stepOnEnemy = false;

        while (!commands.isEmpty() && food > 0) {
            String command = commands.poll();

            if (command.equals("up")) {
                stepOnEnemy = move(matrix, startRow - 1, startCol);

            } else if (command.equals("down")) {
                stepOnEnemy = move(matrix, startRow + 1, startCol);

            } else if (command.equals("left")) {
                stepOnEnemy = move(matrix, startRow, startCol - 1);

            } else if (command.equals("right")) {
                stepOnEnemy = move(matrix, startRow, startCol + 1);

            }

            if (stepOnEnemy) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }


        if (food == 0) {
            System.out.println("You win! Final python length is " + resultFood);
        }
        if (commands.isEmpty() && food > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", food);
        }


    }

    private static boolean move(char[][] matrix, int newRow, int newCol) {

        newRow = checkTheIndex(matrix, newRow);
        newCol = checkTheIndex(matrix, newCol);

        if (matrix[newRow][newCol] == 'f') {
            food--;

        } else if (matrix[newRow][newCol] == 'e') {
            return true;
        }

            startRow = newRow;
            startCol = newCol;

        return false;
    }

    private static int checkTheIndex(char[][] matrix, int index) {

        if (index > matrix.length - 1) {
            index = 0;

        } else if (index < 0) {
            index = matrix.length - 1;
        }
        return index;

    }


}
