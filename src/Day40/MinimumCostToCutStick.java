package Day40;

import java.util.Arrays;

public class MinimumCostToCutStick {
    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] padded = new int[m + 2];
        System.arraycopy(cuts, 0, padded, 1, m);
        padded[m + 1] = n;
        Arrays.sort(padded);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i <= m + 1 - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (padded[j] - padded[i]));
                }
            }
        }

        return dp[0][m + 1];
    }

    public static void main(String[] args) {
        int[] cuts = {1, 3, 4, 5};
        System.out.println("Minimum cost to cut stick: " + minCost(7, cuts));
    }
}