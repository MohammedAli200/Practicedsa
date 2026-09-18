package Day36;

public class StockWithCooldown {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[] held = new int[n];
        int[] sold = new int[n];
        int[] reset = new int[n];

        held[0] = -prices[0];
        sold[0] = Integer.MIN_VALUE;
        reset[0] = 0;

        for (int i = 1; i < n; i++) {
            held[i] = Math.max(held[i - 1], reset[i - 1] - prices[i]);
            sold[i] = held[i - 1] + prices[i];
            reset[i] = Math.max(reset[i - 1], sold[i - 1]);
        }

        return Math.max(sold[n - 1], reset[n - 1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }
}