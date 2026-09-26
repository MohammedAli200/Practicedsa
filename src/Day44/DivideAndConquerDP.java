package Day44;

import java.util.Arrays;

public class DivideAndConquerDP {
    private static final long INF = (long) 1e18;
    private static long[][] dp;
    private static long[] nums;

    // Cost function C(j, i): example using square difference sum
    private static long cost(int j, int i) {
        if (j >= i) return INF;
        long diff = nums[i - 1] - nums[j];
        return diff * diff;
    }

    private static void compute(int k, int l, int r, int optL, int optR) {
        if (l > r) return;

        int mid = (l + r) / 2;
        int opt = -1;
        dp[k][mid] = INF;

        for (int i = optL; i <= Math.min(mid - 1, optR); i++) {
            long val = dp[k - 1][i] + cost(i, mid);
            if (val < dp[k][mid]) {
                dp[k][mid] = val;
                opt = i;
            }
        }

        if (opt == -1) opt = optL;

        // Solve left and right subproblems using monotonicity of opt
        compute(k, l, mid - 1, optL, opt);
        compute(k, mid + 1, r, opt, optR);
    }

    public static long minPartitionCost(long[] arr, int K) {
        nums = arr;
        int n = arr.length;
        dp = new long[K + 1][n + 1];

        for (int i = 0; i <= K; i++) Arrays.fill(dp[i], INF);
        dp[0][0] = 0;

        for (int k = 1; k <= K; k++) {
            compute(k, 1, n, 0, n - 1);
        }

        return dp[K][n];
    }

    public static void main(String[] args) {
        long[] arr = {1, 3, 7, 12, 20};
        int K = 2;
        System.out.println("Min Partition Cost (D&C DP): " + minPartitionCost(arr, K));
    }
}