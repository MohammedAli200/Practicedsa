package Day12;

import java.util.Arrays;
import java.util.Scanner;

public class KthPairDistance {

    static long countPairs(
            int[] nums, int distance) {

        long count = 0;

        int left = 0;

        for (int right = 0;
             right < nums.length;
             right++) {

            while (nums[right] - nums[left] > distance)
                left++;

            count += right - left;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int k = sc.nextInt();

        Arrays.sort(nums);

        int low = 0;
        int high = nums[n - 1] - nums[0];

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (countPairs(nums, mid) >= k)
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(
                "K-th Smallest Distance = " + low);
    }
}