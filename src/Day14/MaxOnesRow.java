package Day14;

import java.util.Scanner;

public class MaxOnesRow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int maxRow = -1;
        int maxOnes = 0;

        for (int i = 0; i < rows; i++) {

            int low = 0;
            int high = cols - 1;
            int firstOne = cols;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (matrix[i][mid] == 1) {
                    firstOne = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            int ones = cols - firstOne;

            if (ones > maxOnes) {
                maxOnes = ones;
                maxRow = i;
            }
        }

        System.out.println("Row = " + maxRow);
        System.out.println("Maximum Ones = " + maxOnes);
    }
}