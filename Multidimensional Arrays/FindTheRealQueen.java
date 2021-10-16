package MultidimentionalArrays;

import java.util.*;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = 8;
        int cols = 8;
        char[][] matrix = readMatrix(scan, rows, cols);

        boolean isFoundQueen = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q' && isValidQ(matrix, row, col)) {
                    System.out.println(row + " " + col);
                    isFoundQueen = true;
                    break;
                }
            }
            if (isFoundQueen) {
                break;
            }
        }


    }


    private static char[][] readMatrix(Scanner scan, int cols, int rows) {
        char[][] myMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String input = scan.nextLine();
            String line = input.replaceAll("\\s+", "");
            myMatrix[row] = line.toCharArray();
        }


        return myMatrix;
    }

    private static boolean isValidQ(char[][] board, int row, int col) {
        for (int rowDirect = -1; rowDirect <= 1; rowDirect++) {
            for (int colDirect = -1; colDirect <= 1; colDirect++) {

                if (rowDirect == 0 && colDirect == 0) {
                    continue;
                }

                int currentRow = row + rowDirect;
                int currentCol = col + colDirect;

                boolean inBounds = isInBounds(board, currentRow, currentCol);

                while (inBounds) {
                    if (board[currentRow][currentCol] == 'q') {
                        return false;
                    }
                    currentRow = currentRow + rowDirect;
                    currentCol = currentCol + colDirect;
                    inBounds = isInBounds(board, currentRow, currentCol);
                }
            }
        }
        return true;
    }

    private static boolean isInBounds(char[][] board, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < board.length && currentCol >= 0
                && currentCol < board[currentRow].length;
    }

}




