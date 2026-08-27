package Day16;

import java.util.Scanner;

public class MatrixMedian {

    static int upperBound(
            int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    static int countLessEqual(
            int[][] matrix, int value) {

        int count = 0;

        for (int[] row : matrix)
            count += upperBound(row, value);

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = sc.nextInt();

                low = Math.min(
                        low, matrix[i][j]);

                high = Math.max(
                        high, matrix[i][j]);
            }
        }

        int required = (rows * cols + 1) / 2;

        while (low < high) {

            int mid =
                    low + (high - low) / 2;

            if (countLessEqual(
                    matrix, mid) >= required)

                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(
                "Median = " + low);
    }
}