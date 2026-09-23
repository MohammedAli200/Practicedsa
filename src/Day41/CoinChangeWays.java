package Day41;

public class CoinChangeWays {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: 1 way to make amount 0 (using no coins)

        // Outer loop over coins ensures ordered combinations (no duplicate permutations)
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Total combination ways: " + change(amount, coins));
    }
}