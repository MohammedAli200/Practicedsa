package Day48;

import java.util.Arrays;

public class SubmaskMinPlusSOSDP {
    private static final int INF = (int) 1e9;

    public static int[] minPlusSubmaskConvolution(int[] A, int[] B, int n) {
        int totalMasks = 1 << n;
        int[] dpA = Arrays.copyOf(A, totalMasks);
        int[] dpB = Arrays.copyOf(B, totalMasks);

        // Transform A and B through SOS DP over submasks
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < totalMasks; mask++) {
                if ((mask & (1 << i)) != 0) {
                    dpA[mask] = Math.min(dpA[mask], dpA[mask ^ (1 << i)]);
                    dpB[mask] = Math.min(dpB[mask], dpB[mask ^ (1 << i)]);
                }
            }
        }

        // Pointwise min-plus addition
        int[] res = new int[totalMasks];
        for (int mask = 0; mask < totalMasks; mask++) {
            res[mask] = dpA[mask] + dpB[mask];
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int totalMasks = 1 << n;
        int[] A = {0, 5, 2, INF, 8, INF, INF, INF};
        int[] B = {0, 1, INF, 4, INF, INF, INF, INF};

        int[] result = minPlusSubmaskConvolution(A, B, n);
        System.out.println("Min-Plus SOS result for mask 7 (111 in binary): " + result[7]);
    }
}