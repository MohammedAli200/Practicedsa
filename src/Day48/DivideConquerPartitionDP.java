package Day48;

import java.util.Arrays;

public class DivideConquerPartitionDP {
    private static final long INF = (long) 1e18;
    private static long[][] dp;
    private static long[] pref;

    // Cost function C(j, i): example sum of subarray squared
    private static long cost(int j, int i) {
        if (j >= i) return INF;
        long sum = pref[i] - pref[j];
        return sum * sum;
    }

    private static void solve(int k, int l, int r, int optL, int optR) {
        if (l > r) return;

        int mid = (l + r) / 2;
        int opt = -1;
        dp[k][mid] = INF;

        for (int j = optL; j <= Math.min(mid - 1, optR); j++) {
            long val = dp[k - 1][j] + cost(j, mid);
            if (val < dp[k][mid]) {
                dp[k][mid] = val;
                opt = j;
            }
        }

        if (opt == -1) opt = optL;

        // Recurse on left and right halves using monotonicity of opt
        solve(k, l, mid - 1, optL, opt);
        solve(k, mid + 1, r, opt, optR);
    }

    public static long minPartitionCost(int[] arr, int K) {
        int n = arr.length;
        pref = new long[n + 1];
        for (int i = 1; i <= n; i++) pref[i] = pref[i - 1] + arr[i - 1];

        dp = new long[K + 1][n + 1];
        for (long[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int k = 1; k <= K; k++) {
            solve(k, 1, n, 0, n - 1);
        }

        return dp[K][n];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 7, 5};
        int K = 3;
        System.out.println("Min Subarray Partition Cost (D&C DP): " + minPartitionCost(arr, K));
    }
}