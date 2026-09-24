package Day42;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathAllNodes {
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;

        int finalState = (1 << n) - 1; // All nodes visited bitmask
        Queue<int[]> queue = new LinkedList<>(); // {node, mask}
        boolean[][] visited = new boolean[n][1 << n];

        // Initialize queue with all nodes as potential starting points
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int u = curr[0];
                int mask = curr[1];

                if (mask == finalState) return steps;

                for (int v : graph[u]) {
                    int nextMask = mask | (1 << v);
                    if (!visited[v][nextMask]) {
                        visited[v][nextMask] = true;
                        queue.offer(new int[]{v, nextMask});
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println("Shortest path visiting all nodes: " + shortestPathLength(graph));
    }
}