package Day5;

import java.util.Scanner;

public class SquareRootBinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        if (n < 2) {
            System.out.println("Square Root = " + n);
            return;
        }

        long low = 1;
        long high = n;
        long answer = 1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (mid <= n / mid) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Square Root = " + answer);
    }
}