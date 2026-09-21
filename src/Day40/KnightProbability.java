package Day40;

public class KnightProbability {
    public static double knightProbability(int n, int k, int row, int column) {
        int[][] moves = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        double[][] dp = new double[n][n];
        dp[row][column] = 1.0;

        for (int step = 0; step < k; step++) {
            double[][] nextDp = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] move : moves) {
                            int nr = r + move[0];
                            int nc = c + move[1];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                nextDp[nr][nc] += dp[r][c] / 8.0;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }

        double totalProb = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                totalProb += dp[r][c];
            }
        }

        return totalProb;
    }

    public static void main(String[] args) {
        System.out.println("Knight Probability: " + knightProbability(3, 2, 0, 0));
    }
}