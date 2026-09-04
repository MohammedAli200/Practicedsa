package Day24;

import java.util.*;

public class Main6 {

    static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (countPairs(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static int countPairs(int[] nums, int distance) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            while (nums[right] - nums[left] > distance) {
                left++;
            }

            count += right - left;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        int k = 1;

        System.out.println(smallestDistancePair(nums, k));
    }
}