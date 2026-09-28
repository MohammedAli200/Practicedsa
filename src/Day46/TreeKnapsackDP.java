package Day46;

import java.util.*;

public class TreeKnapsackDP {
    private static List<List<Integer>> adj;
    private static int[] weight, value, subtreeSize;
    private static int[][] dp;

    public static int getMaxTreeKnapsack(int n, int[][] edges, int[] w, int[] v, int capacity) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        weight = w;
        value = v;
        subtreeSize = new int[n];
        dp = new int[n][capacity + 1];

        dfs(0, capacity);
        return dp[0][capacity];
    }

    private static void dfs(int u, int K) {
        subtreeSize[u] = 1;
        dp[u][0] = 0;

        // Base case: item u itself
        if (weight[u] <= K) {
            dp[u][weight[u]] = value[u];
        }

        for (int v : adj.get(u)) {
            dfs(v, K);

            // Merge subtree v into u (bounded by subtree sizes for O(N * K) efficiency)
            for (int i = Math.min(K, subtreeSize[u] + subtreeSize[v]); i >= weight[u]; i--) {
                for (int j = 1; j <= Math.min(i - weight[u], subtreeSize[v]); j++) {
                    if (dp[u][i - j] > 0 || i - j == weight[u]) {
                        dp[u][i] = Math.max(dp[u][i], dp[u][i - j] + dp[v][j]);
                    }
                }
            }

            subtreeSize[u] += subtreeSize[v];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}};
        int[] w = {2, 3, 1, 4};
        int[] v = {10, 20, 15, 30};
        int capacity = 5;

        System.out.println("Max Tree Knapsack Value: " + getMaxTreeKnapsack(n, edges, w, v, capacity));
    }
}