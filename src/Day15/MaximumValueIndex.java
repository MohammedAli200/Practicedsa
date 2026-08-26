package Day15;

import java.util.Scanner;

public class MaximumValueIndex {

    static long sumSide(
            long value, long length) {

        if (value > length) {

            long first = value - length;

            return (first + value - 1) * length / 2;

        } else {

            return value * (value - 1) / 2
                    + (length - (value - 1));
        }
    }

    static boolean possible(
            long value,
            int n,
            int index,
            long maxSum) {

        long left = sumSide(value, index);

        long right = sumSide(
                value,
                n - index - 1);

        long total = left + value + right;

        return total <= maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int index = sc.nextInt();
        long maxSum = sc.nextLong();

        long low = 1;
        long high = maxSum;
        long answer = 1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (possible(
                    mid, n, index, maxSum)) {

                answer = mid;
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}