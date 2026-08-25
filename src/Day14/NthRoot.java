package Day14;

import java.util.Scanner;

public class NthRoot {

    static int comparePower(long x, int n, long target) {

        long result = 1;

        for (int i = 0; i < n; i++) {

            if (result > target / x)
                return 1;

            result *= x;
        }

        if (result == target)
            return 0;

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long number = sc.nextLong();

        long low = 1;
        long high = number;
        long answer = 1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            int result = comparePower(mid, n, number);

            if (result == 0) {
                answer = mid;
                break;
            }

            if (result < 0) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("N-th Root = " + answer);
    }
}