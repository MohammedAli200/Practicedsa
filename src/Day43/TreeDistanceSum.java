package Day43;

import java.util.*;

public class TreeDistanceSum {
    private static int[] ans, count;
    private static List<Set<Integer>> tree;

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) tree.add(new HashSet<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Pass 1: Compute counts and subtree distance sums rooted at 0
        dfs1(0, -1);
        // Pass 2: Rerooting DP to transition node answers to neighbors
        dfs2(0, -1, n);

        return ans;
    }

    private static void dfs1(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs1(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    private static void dfs2(int node, int parent, int n) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                ans[child] = ans[node] - count[child] + (n - count[child]);
                dfs2(child, node, n);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println("Sum of Distances: " + Arrays.toString(sumOfDistancesInTree(n, edges)));
    }
}