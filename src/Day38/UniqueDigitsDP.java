package Day38;

public class UniqueDigitsDP {
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;  // 0-digit number (0)
        dp[1] = 10; // Numbers from 0 to 9

        int availableDigits = 9;
        int uniqueChoices = 9;

        for (int i = 2; i <= n && availableDigits > 0; i++) {
            uniqueChoices *= availableDigits;
            dp[i] = dp[i - 1] + uniqueChoices;
            availableDigits--;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Numbers with unique digits for n=" + n + ": " + countNumbersWithUniqueDigits(n));
    }
}