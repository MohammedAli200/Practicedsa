package Day38;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // Sort width ascending; if width matches, sort height descending
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Find LIS on heights
        int[] dp = new int[envelopes.length];
        int maxEnvelopes = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int idx = Arrays.binarySearch(dp, 0, maxEnvelopes, height);
            if (idx < 0) idx = -(idx + 1);

            dp[idx] = height;
            if (idx == maxEnvelopes) {
                maxEnvelopes++;
            }
        }

        return maxEnvelopes;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println("Max Russian Doll Envelopes: " + maxEnvelopes(envelopes));
    }
}