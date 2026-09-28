package Day46;

import java.util.Arrays;

public class TSPBitmaskDP {
    private static final int INF = (int) 1e9;

    public static int tsp(int[][] dist) {
        int n = dist.length;
        int totalStates = 1 << n;
        int[][] dp = new int[totalStates][n];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Base case: starting at node 0
        dp[1][0] = 0;

        for (int mask = 1; mask < totalStates; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0 || dp[mask][u] == INF) continue;

                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) == 0) {
                        int nextMask = mask | (1 << v);
                        dp[nextMask][v] = Math.min(dp[nextMask][v], dp[mask][u] + dist[u][v]);
                    }
                }
            }
        }

        // Return to starting node 0
        int minCost = INF;
        int fullMask = (1 << n) - 1;
        for (int u = 1; u < n; u++) {
            if (dp[fullMask][u] != INF) {
                minCost = Math.min(minCost, dp[fullMask][u] + dist[u][0]);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] dist = {
                {0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0}
        };
        System.out.println("Minimum TSP Cost: " + tsp(dist));
    }
}