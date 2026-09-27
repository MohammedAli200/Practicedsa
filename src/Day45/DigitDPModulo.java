package Day45;

import java.util.Arrays;

public class DigitDPModulo {
    private static int[][][][] dp;

    public static int countNumbers(String N, int K) {
        int len = N.length();
        dp = new int[len][K][2][2];
        for (int[][][] a : dp)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        return solve(0, 0, 1, 1, N, K);
    }

    private static int solve(int idx, int sumMod, int tight, int leadingZero, String N, int K) {
        if (idx == N.length()) {
            return (sumMod == 0 && leadingZero == 0) ? 1 : 0;
        }

        if (dp[idx][sumMod][tight][leadingZero] != -1) {
            return dp[idx][sumMod][tight][leadingZero];
        }

        int limit = (tight == 1) ? (N.charAt(idx) - '0') : 9;
        int count = 0;

        for (int d = 0; d <= limit; d++) {
            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            int nextLeadingZero = (leadingZero == 1 && d == 0) ? 1 : 0;
            int nextSumMod = (nextLeadingZero == 1) ? 0 : (sumMod + d) % K;

            count += solve(idx + 1, nextSumMod, nextTight, nextLeadingZero, N, K);
        }

        return dp[idx][sumMod][tight][leadingZero] = count;
    }

    public static void main(String[] args) {
        String N = "20";
        int K = 3;
        System.out.println("Count of numbers <= " + N + " with digit sum divisible by " + K + ": " + countNumbers(N, K));
    }
}