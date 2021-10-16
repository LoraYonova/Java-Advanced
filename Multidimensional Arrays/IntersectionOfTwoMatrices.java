package MultidimentionalArrays;


import java.util.Scanner;


public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());


        String [][] firstMatrices = new String[rows][cols];
        String [][] secondMatrices = new String[rows][cols];
        String [][] thirdMatrices = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            firstMatrices[i] = scan.nextLine().split("\\s+");

        }
        for (int i = 0; i < rows; i++) {
            secondMatrices[i] = scan.nextLine().split("\\s+");
        }

        for (int i = 0; i < firstMatrices.length; i++) {
            for (int j = 0; j < firstMatrices[i].length; j++) {
                if(!firstMatrices[i][j].equals(secondMatrices[i][j])){
                    thirdMatrices[i][j] = "*";
                } else {
                    thirdMatrices[i][j] = firstMatrices[i][j];
                }

            }
        }
        for (int i = 0; i < thirdMatrices.length; i++) {
            for (int j = 0; j < thirdMatrices[i].length; j++) {
                System.out.print(thirdMatrices[i][j] + " ");
            }
            System.out.println();
        }


    }
}
