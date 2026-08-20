package Day9;

import java.util.Scanner;

public class KthSmallestMultiplicationTable {

    static long countLessEqual(
            int m, int n, int value) {

        long count = 0;

        for (int i = 1; i <= m; i++) {

            count += Math.min(
                    n,
                    value / i);
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int low = 1;
        int high = m * n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (countLessEqual(m, n, mid) >= k)
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(
                "K-th Smallest Number = " + low);
    }
}