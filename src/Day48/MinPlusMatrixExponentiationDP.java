package Day48;

import java.util.Arrays;

public class MinPlusMatrixExponentiationDP {
    private static final long INF = (long) 1e15;

    public static long[][] shortestPathLengthK(long[][] graph, int K) {
        int n = graph.length;
        long[][] res = new long[n][n];

        // Initialize identity under Min-Plus algebra
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], INF);
            res[i][i] = 0;
        }

        long[][] base = new long[n][n];
        for (int i = 0; i < n; i++) {
            base[i] = Arrays.copyOf(graph[i], n);
        }

        while (K > 0) {
            if ((K & 1) == 1) res = minPlusMultiply(res, base);
            base = minPlusMultiply(base, base);
            K >>= 1;
        }

        return res;
    }

    private static long[][] minPlusMultiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(C[i], INF);

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (B[k][j] == INF) continue;
                    C[i][j] = Math.min(C[i][j], A[i][k] + B[k][j]);
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int n = 4;
        long[][] graph = new long[n][n];
        for (long[] row : graph) Arrays.fill(row, INF);

        graph[0][1] = 2;
        graph[1][2] = 3;
        graph[2][3] = 1;
        graph[0][2] = 7;

        int K = 3;
        long[][] shortestK = shortestPathLengthK(graph, K);

        System.out.println("Shortest path of exact length " + K + " from node 0 to 3: " + shortestK[0][3]);
    }
}