package Day48;

import java.util.Arrays;

public class ProfileGridConnectivityDP {
    private static final int MOD = 1_000_000_007;

    public static int countConnectedGridPaths(int rows, int cols) {
        int totalProfiles = 1 << cols;
        int[][] dp = new int[cols + 1][totalProfiles];
        dp[0][0] = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int[][] nextDp = new int[cols + 1][totalProfiles];

                for (int mask = 0; mask < totalProfiles; mask++) {
                    if (dp[c][mask] == 0) continue;

                    boolean leftState = (c > 0) && ((mask & (1 << (c - 1))) != 0);
                    boolean upState = (mask & (1 << c)) != 0;

                    // Option 1: Skip placing path edge
                    int mask1 = mask & ~(1 << c);
                    nextDp[c + 1][mask1] = (nextDp[c + 1][mask1] + dp[c][mask]) % MOD;

                    // Option 2: Place path edge connected to left/up
                    if (!leftState || !upState) {
                        int mask2 = mask | (1 << c);
                        nextDp[c + 1][mask2] = (nextDp[c + 1][mask2] + dp[c][mask]) % MOD;
                    }
                }
                dp = nextDp;
            }

            // Carry profile state over row boundary
            int[] rowEnd = new int[totalProfiles];
            for (int mask = 0; mask < totalProfiles; mask++) {
                rowEnd[mask] = dp[cols][mask];
            }
            dp = new int[cols + 1][totalProfiles];
            dp[0] = rowEnd;
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int rows = 3, cols = 3;
        System.out.println("Grid Profile DP Path Count for 3x3: " + countConnectedGridPaths(rows, cols));
    }
}