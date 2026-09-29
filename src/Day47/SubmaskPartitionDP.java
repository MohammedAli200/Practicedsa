package Day47;

import java.util.Arrays;

public class SubmaskPartitionDP {
    private static final int INF = (int) 1e9;

    public static int minCostPartition(int n, int[] costPerSubmask) {
        int totalMasks = 1 << n;
        int[] dp = new int[totalMasks];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int mask = 1; mask < totalMasks; mask++) {
            // Iterate over all valid non-empty submasks of 'mask'
            for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                if (costPerSubmask[submask] != INF) {
                    dp[mask] = Math.min(dp[mask], dp[mask ^ submask] + costPerSubmask[submask]);
                }
            }
        }

        return dp[totalMasks - 1];
    }

    public static void main(String[] args) {
        int n = 3;
        int totalMasks = 1 << n;
        int[] costPerSubmask = new int[totalMasks];
        Arrays.fill(costPerSubmask, INF);

        // Predefined costs for subset configurations
        costPerSubmask[1] = 10; // {0}
        costPerSubmask[2] = 12; // {1}
        costPerSubmask[4] = 15; // {2}
        costPerSubmask[3] = 18; // {0, 1}
        costPerSubmask[5] = 22; // {0, 2}
        costPerSubmask[7] = 30; // {0, 1, 2}

        System.out.println("Minimum Cost to Partition Submasks: " + minCostPartition(n, costPerSubmask));
    }
}