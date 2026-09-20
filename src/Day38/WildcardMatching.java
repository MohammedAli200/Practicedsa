package Day38;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Base case: Leading '*' in pattern can match empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j - 1);
                if (pChar == '?' || pChar == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // Match empty sequence (dp[i][j-1]) or extend sequence match (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa", p = "*";
        System.out.println("Pattern Matches: " + isMatch(s, p));
    }
}