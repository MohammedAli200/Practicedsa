package Day18;

import java.util.Scanner;

public class FloorSquareRoot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long low = 0;
        long high = n;
        long answer = 0;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (mid <= n / mid) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(
                "Floor Square Root = " + answer);
    }
}