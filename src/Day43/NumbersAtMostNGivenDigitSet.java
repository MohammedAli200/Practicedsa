package Day43;

import java.util.Arrays;

public class NumbersAtMostNGivenDigitSet {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        String S = String.valueOf(n);
        int K = S.length();
        int[] dp = new int[K + 1];
        dp[K] = 1; // Base case: exact match for full prefix

        for (int i = K - 1; i >= 0; i--) {
            int si = S.charAt(i) - '0';
            for (String digit : digits) {
                int d = Integer.parseInt(digit);
                if (d < si) {
                    dp[i] += Math.pow(digits.length, K - 1 - i);
                } else if (d == si) {
                    dp[i] += dp[i + 1];
                }
            }
        }

        // Sum for numbers with fewer digits than N
        for (int i = 1; i < K; i++) {
            dp[0] += Math.pow(digits.length, i);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        String[] digits = {"1", "3", "5", "7"};
        int n = 100;
        System.out.println("Count of numbers <= " + n + ": " + atMostNGivenDigitSet(digits, n));
    }
}