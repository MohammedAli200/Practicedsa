package Day46;

import java.util.Arrays;

public class DigitDPProduct {
    private static Long[][][][][] dp;

    public static long countValidNumbers(String N, int M) {
        int len = N.length();
        dp = new Long[len][10][M][2][2];

        return solve(0, 0, 1, 1, 1, N, M);
    }

    private static long solve(int idx, int lastDigit, int prodMod, int tight, int isZero, String N, int M) {
        if (idx == N.length()) {
            return (isZero == 0 && prodMod == 0) ? 1 : 0;
        }

        if (dp[idx][lastDigit][prodMod][tight][isZero] != null) {
            return dp[idx][lastDigit][prodMod][tight][isZero];
        }

        int limit = (tight == 1) ? (N.charAt(idx) - '0') : 9;
        long count = 0;

        for (int d = 0; d <= limit; d++) {
            if (isZero == 0 && d < lastDigit) continue; // Must maintain non-decreasing order

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            int nextIsZero = (isZero == 1 && d == 0) ? 1 : 0;
            int nextLastDigit = (nextIsZero == 1) ? 0 : d;
            int nextProdMod = (nextIsZero == 1) ? 1 : (prodMod * d) % M;

            count += solve(idx + 1, nextLastDigit, nextProdMod, nextTight, nextIsZero, N, M);
        }

        return dp[idx][lastDigit][prodMod][tight][isZero] = count;
    }

    public static void main(String[] args) {
        String N = "500";
        int M = 6;
        System.out.println("Count of non-decreasing digit numbers <= " + N + " with product mod " + M + " = 0: " + countValidNumbers(N, M));
    }
}