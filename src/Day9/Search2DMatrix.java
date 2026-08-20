package Day9;

import java.util.Scanner;

public class Search2DMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        int target = sc.nextInt();

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                System.out.println(true);
                return;
            }

            if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println(false);
    }
}