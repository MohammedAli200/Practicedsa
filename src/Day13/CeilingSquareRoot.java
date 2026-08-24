package Day13;

import java.util.Scanner;

public class CeilingSquareRoot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        if (n <= 0) {
            System.out.println("Answer = 0");
            return;
        }

        long low = 1;
        long high = n;
        long answer = n;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (mid >= n / mid) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        // Correct the case where mid*mid is not exactly n
        if (answer * answer < n)
            answer++;

        System.out.println("Answer = " + answer);
    }
}