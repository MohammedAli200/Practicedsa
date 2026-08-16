package Day5;

import java.util.Scanner;

public class RowMaximumOnes {

    static int firstOne(int[] row) {

        int low = 0;
        int high = row.length - 1;
        int answer = row.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (row[mid] == 1) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        int maxOnes = 0;
        int answerRow = -1;

        for (int i = 0; i < rows; i++) {

            int first = firstOne(matrix[i]);

            int ones = cols - first;

            if (ones > maxOnes) {
                maxOnes = ones;
                answerRow = i;
            }
        }

        System.out.println(
                "Row with Maximum 1s = " + answerRow);

        System.out.println(
                "Maximum Number of 1s = " + maxOnes);
    }
}