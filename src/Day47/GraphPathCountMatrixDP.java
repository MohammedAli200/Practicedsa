package Day47;

public class GraphPathCountMatrixDP {
    private static final long MOD = 1_000_000_007;

    public static long[][] countPathsOfLengthK(int[][] graph, int K) {
        int n = graph.length;
        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = graph[i][j];
            }
        }

        return matrixPower(mat, K);
    }

    private static long[][] matrixPower(long[][] A, int p) {
        int n = A.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1; // Identity matrix

        long[][] base = A;
        while (p > 0) {
            if ((p & 1) == 1) res = multiply(res, base);
            base = multiply(base, base);
            p >>= 1;
        }

        return res;
    }

    private static long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] adj = {
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 1},
                {0, 0, 0, 0}
        };
        int K = 4;
        long[][] paths = countPathsOfLengthK(adj, K);

        System.out.println("Total paths of length " + K + " from node 0 to node 3: " + paths[0][3]);
    }
}