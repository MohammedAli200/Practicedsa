package Day24;

import java.util.*;

public class Main2 {

    static long maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = 0;

        for (int x : candies) {
            high = Math.max(high, x);
        }

        long answer = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canDistribute(candies, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    static boolean canDistribute(int[] candies, long k, long size) {
        long children = 0;

        for (int x : candies) {
            children += x / size;

            if (children >= k)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        long k = 3;

        System.out.println(maximumCandies(candies, k));
    }
}
