package Day7;

import java.util.Scanner;

public class MaximumCandies {

    static boolean canDistribute(
            int[] candies, long k, int each) {

        long children = 0;

        for (int pile : candies) {

            children += pile / each;

            if (children >= k)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] candies = new int[n];

        int high = 0;

        for (int i = 0; i < n; i++) {

            candies[i] = sc.nextInt();
            high = Math.max(high, candies[i]);
        }

        long k = sc.nextLong();

        int low = 1;
        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canDistribute(candies, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(
                "Maximum Candies Per Child = " + answer);
    }
}