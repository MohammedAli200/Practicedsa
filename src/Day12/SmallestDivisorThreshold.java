package Day12;

import java.util.Scanner;

public class SmallestDivisorThreshold {

    static boolean possible(
            int[] nums, int divisor, int threshold) {

        int sum = 0;

        for (int num : nums) {

            sum += (num + divisor - 1) / divisor;

            if (sum > threshold)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        int high = 0;

        for (int i = 0; i < n; i++) {

            nums[i] = sc.nextInt();

            high = Math.max(high, nums[i]);
        }

        int threshold = sc.nextInt();

        int low = 1;
        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(nums, mid, threshold)) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        System.out.println(
                "Smallest Divisor = " + answer);
    }
}