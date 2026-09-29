package Day47;

public class StoneGameMinimax {
    public static int maxScoreDiff(int[] stones) {
        int n = stones.length;
        // dp[i][j] = max net score advantage for the player whose turn it is on interval [i, j]
        int[][] dp = new int[n][n];

        // Base cases: single stone remaining
        for (int i = 0; i < n; i++) {
            dp[i][i] = stones[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // Minimax: take left stone minus rival's best outcome OR right stone minus rival's best
                dp[i][j] = Math.max(stones[i] - dp[i + 1][j], stones[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] stones = {5, 3, 4, 5};
        int netDiff = maxScoreDiff(stones);
        System.out.println("Maximum Net Advantage for Player 1: " + netDiff);
        System.out.println("Can Player 1 win? " + (netDiff > 0));
    }
}