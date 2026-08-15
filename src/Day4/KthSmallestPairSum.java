package Day4;

import java.util.Scanner;

public class KthSmallestPairSum {

    static long countPairs(
            int[] a, int[] b, long target) {

        long count = 0;
        int j = b.length - 1;

        for (int x : a) {

            while (j >= 0 && (long) x + b[j] > target)
                j--;

            if (j < 0)
                break;

            count += j + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int m = sc.nextInt();

        int[] b = new int[m];

        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        long k = sc.nextLong();

        long low = (long) a[0] + b[0];

        long high =
                (long) a[n - 1] + b[m - 1];

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (countPairs(a, b, mid) >= k)
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(
                "K-th Smallest Pair Sum = " + low);
    }
}