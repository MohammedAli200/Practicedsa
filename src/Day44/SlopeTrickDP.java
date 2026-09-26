package Day44;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlopeTrickDP {
    public static long minOperationsToMakeNonDecreasing(int[] nums) {
        long minCost = 0;
        // PriorityQueue storing left slope change points (max-heap)
        PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            if (!leftMax.isEmpty() && leftMax.peek() > num) {
                // Minimum cost increases by difference between max peak and current value
                minCost += leftMax.peek() - num;
                leftMax.poll();
                leftMax.add(num); // Add twice to update slope derivative
            }
            leftMax.add(num);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 1, 2};
        System.out.println("Min Operations to Make Array Non-Decreasing: " + minOperationsToMakeNonDecreasing(nums));
    }
}