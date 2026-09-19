package Day37;

public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] padded = new int[n + 2];
        padded[0] = 1;
        padded[n + 1] = 1;
        for (int i = 0; i < n; i++) padded[i + 1] = nums[i];

        int[][] dp = new int[n + 2][n + 2];

        // len is the length of the interval of balloons being burst
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                // k is the LAST balloon burst in interval [left, right]
                for (int k = left; k <= right; k++) {
                    int coins = padded[left - 1] * padded[k] * padded[right + 1];
                    coins += dp[left][k - 1] + dp[k + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] balloons = {3, 1, 5, 8};
        System.out.println("Maximum coins from bursting balloons: " + maxCoins(balloons));
    }
}