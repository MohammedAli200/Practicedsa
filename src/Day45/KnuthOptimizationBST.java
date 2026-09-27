package Day45;

public class KnuthOptimizationBST {
    public static int minSearchCost(int[] freq) {
        int n = freq.length;
        int[][] dp = new int[n + 2][n + 2];
        int[][] opt = new int[n + 2][n + 2];
        int[] pref = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + freq[i - 1];
            dp[i][i] = freq[i - 1];
            opt[i][i] = i;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int weight = pref[j] - pref[i - 1];

                // Bound search range using Knuth's inequality
                int kLow = opt[i][j - 1];
                int kHigh = (i + 1 <= j) ? opt[i + 1][j] : j;

                for (int k = kLow; k <= Math.min(j - 1, kHigh); k++) {
                    int val = dp[i][k] + dp[k + 1][j] + weight;
                    if (val < dp[i][j]) {
                        dp[i][j] = val;
                        opt[i][j] = k;
                    }
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] freq = {34, 8, 50};
        System.out.println("Min Optimal BST Search Cost: " + minSearchCost(freq));
    }
}