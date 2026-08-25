package Day14;

import java.util.Scanner;

public class SplitArrayLargestSum {

    static boolean canSplit(
            int[] nums, int parts, long limit) {

        int count = 1;
        long sum = 0;

        for (int num : nums) {

            if (num > limit)
                return false;

            if (sum + num > limit) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return count <= parts;
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

        int parts = sc.nextInt();

        long answer = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canSplit(nums, parts, mid)) {
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