package Day41;

public class UniqueBSTs {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty tree base case
        dp[1] = 1; // Single node base case

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j is chosen as the root; left subtree has (j-1) nodes, right has (i-j)
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Total unique BSTs for n=" + n + ": " + numTrees(n));
    }
}