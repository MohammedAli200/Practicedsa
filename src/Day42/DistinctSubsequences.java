package Day42;

public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // An empty target `t` can be formed by deleting all chars in `s` (1 way)
        for (int i = 0; i <= m; i++) dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Sum of options: include current s char or exclude it
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Exclude current s char
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println("Number of distinct subsequences: " + numDistinct(s, t));
    }
}