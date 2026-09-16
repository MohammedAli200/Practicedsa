package Day35;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // Mathematical conversion: P - N = target, P + N = sum -> 2P = target + sum
        if (sum < Math.abs(target) || (target + sum) % 2 != 0) return 0;

        int s1 = (target + sum) / 2;
        int[] dp = new int[s1 + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = s1; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[s1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("Number of ways to form target: " + findTargetSumWays(nums, target));
    }
}