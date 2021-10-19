package MockExams;


import java.util.Scanner;

public class Selling {
    static int startRow = 0;
    static int startCol = 0;
    static int money = 0;

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

        boolean isBakery = true;
        while (money < 50 && isBakery) {

            String commands = scan.nextLine();

            if (commands.equals("up")) {
                isBakery = move(matrix, startRow - 1, startCol);
            } else if (commands.equals("down")) {
                isBakery = move(matrix, startRow + 1, startCol);
            } else if (commands.equals("left")) {
                isBakery = move(matrix, startRow, startCol - 1);
            } else if (commands.equals("right")) {
                isBakery = move(matrix, startRow, startCol + 1);

            }


        }

        if (!isBakery) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);

        printMatrix(matrix);


    }

    private static boolean move(char[][] matrix, int newRow, int newCol) {


        matrix[startRow][startCol] = '-';
        if (indexOutOfBounds(matrix, newRow, newCol)) {
        char symbol = matrix[newRow][newCol];

            if (matrix[newRow][newCol] == 'O') {
                matrix[newRow][newCol] = '-';
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                            if(matrix[i][j] == 'O') {
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

    private static boolean indexOutOfBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
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
