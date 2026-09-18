package Day36;

public class MatrixChainMultiplication {
    public static int matrixMultiplication(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];

        // len is the chain length
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] p = {10, 20, 30, 40, 30}; // Matrices: 10x20, 20x30, 30x40, 40x30
        System.out.println("Min Operations: " + matrixMultiplication(p));
    }
}