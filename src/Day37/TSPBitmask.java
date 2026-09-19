package Day37;

import java.util.Arrays;

public class TSPBitmask {
    private static final int INF = 1_000_000_000;

    public static int tsp(int[][] dist, int mask, int pos, int n, int[][] dp) {
        // Base case: all cities visited (all bits set to 1)
        if (mask == (1 << n) - 1) {
            return dist[pos][0]; // Return to starting city (0)
        }

        if (dp[mask][pos] != -1) return dp[mask][pos];

        int ans = INF;
        for (int city = 0; city < n; city++) {
            // Check if city is unvisited
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tsp(dist, mask | (1 << city), city, n, dp);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        int[][] dist = {
                {0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0}
        };
        int n = dist.length;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println("Minimum TSP Tour Cost: " + tsp(dist, 1, 0, n, dp));
    }
}