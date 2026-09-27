package Day45;

import java.util.Arrays;

public class SumOverSubsetsDP {
    public static int[] computeSOS(int[] a, int n) {
        int totalMasks = 1 << n;
        int[] dp = Arrays.copyOf(a, totalMasks);

        // Iterate through each bit position
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < totalMasks; mask++) {
                if ((mask & (1 << i)) != 0) {
                    dp[mask] += dp[mask ^ (1 << i)];
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        int n = 3; // 3 bits -> masks 0 to 7
        int[] a = {1, 2, 4, 8, 16, 32, 64, 128};
        int[] sos = computeSOS(a, n);

        System.out.println("SOS DP for mask 7 (111 in binary): " + sos[7]);
    }
}