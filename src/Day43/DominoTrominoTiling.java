package Day43;

public class DominoTrominoTiling {
    public static int numTilings(int n) {
        if (n <= 2) return n;

        long MOD = 1_000_000_007;
        // dp[i] = fully covered 2xi board
        // p[i]  = partially covered (one square missing) 2xi board
        long[] dp = new long[n + 1];
        long[] p = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        p[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * p[i - 1]) % MOD;
            p[i] = (dp[i - 2] + p[i - 1]) % MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Ways to tile 2x" + n + " grid: " + numTilings(n));
    }
}