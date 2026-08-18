package Day7;

import java.util.Scanner;

public class MaximumValueIndex {

    static long sumSide(long peak, int length) {

        if (peak >= length) {

            long first = peak - length + 1;

            return (first + peak) * length / 2;

        } else {

            long sum = peak * (peak + 1) / 2;

            return sum + (length - peak);
        }
    }

    static boolean possible(
            int n, int index, long maxSum, long peak) {

        long leftLength = index;
        long rightLength = n - index - 1;

        long leftSum =
                sumSide(peak - 1, (int) leftLength);

        long rightSum =
                sumSide(peak - 1, (int) rightLength);

        long total = peak + leftSum + rightSum;

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

            if (possible(n, index, maxSum, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Maximum Value = " + answer);
    }
}