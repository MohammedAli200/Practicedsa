package Day19;

import java.util.Scanner;

public class MedianTwoSortedArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();

        int low = 0;
        int high = n;

        while (low <= high) {

            int partitionA =
                    low + (high - low) / 2;

            int partitionB = n - partitionA;

            int maxLeftA =
                    partitionA == 0
                            ? Integer.MIN_VALUE
                            : a[partitionA - 1];

            int minRightA =
                    partitionA == n
                            ? Integer.MAX_VALUE
                            : a[partitionA];

            int maxLeftB =
                    partitionB == 0
                            ? Integer.MIN_VALUE
                            : b[partitionB - 1];

            int minRightB =
                    partitionB == n
                            ? Integer.MAX_VALUE
                            : b[partitionB];

            if (maxLeftA <= minRightB &&
                    maxLeftB <= minRightA) {

                double median =
                        ((double) Math.max(
                                maxLeftA, maxLeftB)
                                + Math.min(
                                minRightA, minRightB))
                                / 2;

                System.out.println(
                        "Median = " + median);

                return;

            } else if (maxLeftA > minRightB) {

                high = partitionA - 1;

            } else {

                low = partitionA + 1;
            }
        }
    }
}