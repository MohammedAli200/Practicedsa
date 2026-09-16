package Day35;

public class PartitionSubset {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If total sum is odd, equal partition is impossible
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: target 0 is always possible

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can partition equally: " + canPartition(nums));
    }
}