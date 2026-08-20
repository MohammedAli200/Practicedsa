package Day9;

import java.util.Scanner;

public class SearchSortedMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        int target = sc.nextInt();

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            if (matrix[row][col] == target) {

                System.out.println(
                        "Element found at row " +
                                row + ", column " + col);

                return;
            }

            if (matrix[row][col] > target)
                col--;
            else
                row++;
        }

        System.out.println("Element not found");
    }
}