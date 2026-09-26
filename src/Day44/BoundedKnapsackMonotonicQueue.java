package Day44;

import java.util.ArrayDeque;
import java.util.Deque;

public class BoundedKnapsackMonotonicQueue {
    public static int boundedKnapsack(int[] wt, int[] val, int[] count, int W) {
        int n = wt.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            int w = wt[i];
            int v = val[i];
            int c = count[i];

            for (int r = 0; r < w; r++) {
                Deque<Integer> deque = new ArrayDeque<>();

                for (int k = 0; k * w + r <= W; k++) {
                    int cap = k * w + r;
                    int currentVal = dp[cap] - k * v;

                    // Maintain monotonically decreasing queue
                    while (!deque.isEmpty() && currentVal >= dp[deque.peekLast() * w + r] - deque.peekLast() * v) {
                        deque.pollLast();
                    }
                    deque.addLast(k);

                    // Remove elements outside count window
                    if (!deque.isEmpty() && deque.peekFirst() < k - c) {
                        deque.pollFirst();
                    }

                    int bestK = deque.peekFirst();
                    dp[cap] = dp[bestK * w + r] + (k - bestK) * v;
                }
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int[] wt = {2, 3, 4};
        int[] val = {3, 4, 5};
        int[] count = {2, 1, 3}; // Item limits
        int capacity = 8;

        System.out.println("Max Bounded Knapsack Value: " + boundedKnapsack(wt, val, count, capacity));
    }
}