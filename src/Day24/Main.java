package Day24;

import java.util.*;

public class Main {

    static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int x : nums) {
            high = Math.max(high, x);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, mid, threshold)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static boolean isValid(int[] nums, int divisor, int threshold) {
        long sum = 0;

        for (int x : nums) {
            sum += (x + divisor - 1) / divisor;

            if (sum > threshold)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }
}