package Day18;

import java.util.Scanner;

public class CeilingSquareRoot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        if (n == 0) {
            System.out.println("Ceiling Square Root = 0");
            return;
        }

        long low = 1;
        long high = n;
        long answer = n;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (mid >= (n + mid - 1) / mid) {

                if (mid * mid >= n) {
                    answer = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                low = mid + 1;
            }
        }

        System.out.println(
                "Ceiling Square Root = " + answer);
    }
}
