package Day44;

public class BrokenProfileDP {
    private static final int MOD = 1_000_000_007;

    public static int countTilings(int m, int n) {
        // Ensure m <= n to keep mask size 2^m minimal
        if (m > n) {
            int temp = m; m = n; n = temp;
        }

        int totalMasks = 1 << m;
        int[][] dp = new int[n * m + 1][totalMasks];
        dp[0][0] = 1;

        for (int cell = 0; cell < n * m; cell++) {
            int r = cell % m;
            for (int mask = 0; mask < totalMasks; mask++) {
                if (dp[cell][mask] == 0) continue;

                // If current bit is already set by vertical domino from previous row
                if ((mask & 1) != 0) {
                    int nextMask = mask >> 1;
                    dp[cell + 1][nextMask] = (dp[cell + 1][nextMask] + dp[cell][mask]) % MOD;
                } else {
                    // Option 1: Place a vertical domino (if row < m - 1)
                    int nextMask1 = (mask >> 1) | (1 << (m - 1));
                    dp[cell + 1][nextMask1] = (dp[cell + 1][nextMask1] + dp[cell][mask]) % MOD;

                    // Option 2: Place a horizontal domino (if col slot matches and bit is clear)
                    if (r < m - 1 && (mask & 2) == 0) {
                        int nextMask2 = (mask >> 2) << 1;
                        dp[cell + 2][nextMask2] = (dp[cell + 2][nextMask2] + dp[cell][mask]) % MOD;
                    }
                }
            }
        }

        return dp[n * m][0];
    }

    public static void main(String[] args) {
        System.out.println("Tiling ways for 3x4 grid: " + countTilings(3, 4));
    }
}