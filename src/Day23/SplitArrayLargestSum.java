package Day23;

import java.util.Scanner;

public class SplitArrayLargestSum {

    static boolean possible(
            int[] nums,
            int k,
            long maxSum) {

        long current = 0;
        int parts = 1;

        for (int num : nums) {

            if (current + num > maxSum) {

                parts++;
                current = num;

            } else {
                current += num;
            }

            if (parts > k)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        long low = 0;
        long high = 0;

        for (int i = 0; i < n; i++) {

            nums[i] = sc.nextInt();

            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        int k = sc.nextInt();

        long answer = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (possible(nums, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(
                "Minimum Largest Sum = " + answer);
    }
}