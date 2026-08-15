package Day4;

import java.util.Scanner;

public class KthElementTwoArrays {

    static int findKth(int[] a, int[] b, int k) {

        if (a.length > b.length)
            return findKth(b, a, k);

        int n = a.length;
        int m = b.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {

            int cutA = low + (high - low) / 2;
            int cutB = k - cutA;

            int leftA = cutA == 0
                    ? Integer.MIN_VALUE
                    : a[cutA - 1];

            int rightA = cutA == n
                    ? Integer.MAX_VALUE
                    : a[cutA];

            int leftB = cutB == 0
                    ? Integer.MIN_VALUE
                    : b[cutB - 1];

            int rightB = cutB == m
                    ? Integer.MAX_VALUE
                    : b[cutB];

            if (leftA <= rightB && leftB <= rightA)
                return Math.max(leftA, leftB);

            if (leftA > rightB)
                high = cutA - 1;
            else
                low = cutA + 1;
        }

        return -1;
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

        int k = sc.nextInt();

        System.out.println(
                "K-th Element = " +
                        findKth(a, b, k));
    }
}