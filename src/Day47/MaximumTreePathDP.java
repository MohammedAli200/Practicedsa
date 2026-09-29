package Day47;

import java.util.*;

public class MaximumTreePathDP {
    private static List<List<int[]>> adj;
    private static int maxPathSum = Integer.MIN_VALUE;

    public static int maxPathSum(int n, int[][] edges, int[] nodeValues) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        dfs(0, -1, nodeValues);
        return maxPathSum;
    }

    private static int dfs(int u, int p, int[] nodeValues) {
        int maxFirst = 0;
        int maxSecond = 0;

        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int w = edge[1];
            if (v == p) continue;

            int childBranch = dfs(v, u, nodeValues) + w;

            if (childBranch > maxFirst) {
                maxSecond = maxFirst;
                maxFirst = childBranch;
            } else if (childBranch > maxSecond) {
                maxSecond = childBranch;
            }
        }

        // Combine top 2 branches passing through node u
        maxPathSum = Math.max(maxPathSum, nodeValues[u] + maxFirst + maxSecond);

        // Return single longest branch upward
        return nodeValues[u] + maxFirst;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 3}, {0, 2, 2}, {1, 3, 5}, {1, 4, 1}};
        int[] nodeValues = {2, 7, 1, 4, 3};

        System.out.println("Maximum Path Sum in Tree: " + maxPathSum(n, edges, nodeValues));
    }
}