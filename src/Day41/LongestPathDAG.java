package Day41;

import java.util.ArrayList;
import java.util.List;

public class LongestPathDAG {
    public static int findLongestPath(int nodes, List<int[]> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] dp = new int[nodes + 1];
        boolean[] visited = new boolean[nodes + 1];

        // Process all vertices using DFS memoization
        int maxPath = 0;
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                dfs(i, adj, dp, visited);
            }
            maxPath = Math.max(maxPath, dp[i]);
        }

        return maxPath;
    }

    private static void dfs(int node, List<List<Integer>> adj, int[] dp, boolean[] visited) {
        visited[node] = true;
        dp[node] = 0;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, dp, visited);
            }
            dp[node] = Math.max(dp[node], 1 + dp[neighbor]);
        }
    }

    public static void main(String[] args) {
        int nodes = 4;
        List<int[]> edges = List.of(
                new int[]{1, 2}, new int[]{1, 3},
                new int[]{2, 4}, new int[]{3, 4}
        );
        System.out.println("Longest Path Length in DAG: " + findLongestPath(nodes, edges));
    }
}