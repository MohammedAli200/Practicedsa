package Day11;

import java.util.Scanner;

public class MatrixPeak {

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

        int low = 0;
        int high = cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int maxRow = 0;

            for (int i = 1; i < rows; i++) {
                if (matrix[i][mid] > matrix[maxRow][mid])
                    maxRow = i;
            }

            int left = mid > 0
                    ? matrix[maxRow][mid - 1]
                    : -1;

            int right = mid < cols - 1
                    ? matrix[maxRow][mid + 1]
                    : -1;

            if (matrix[maxRow][mid] >= left &&
                    matrix[maxRow][mid] >= right) {

                System.out.println(
                        "Peak Element = " +
                                matrix[maxRow][mid]);

                return;
            }

            if (left > matrix[maxRow][mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
    }
}