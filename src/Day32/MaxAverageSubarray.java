package Day32;

public class MaxAverageSubarray {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // Build first window of size k
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Add incoming, remove outgoing
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Max average: " + findMaxAverage(nums, k)); // Output: 12.75
    }
}