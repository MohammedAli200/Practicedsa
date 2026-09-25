package Day43;

import java.util.*;

public class PartitionMinDifference {
    public static int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int sum = 0;
        for (int num : nums) sum += num;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        // Map size -> list of possible subset sums for left and right halves
        Map<Integer, List<Integer>> leftSums = new HashMap<>();
        Map<Integer, List<Integer>> rightSums = new HashMap<>();

        for (int k = 0; k <= n; k++) {
            leftSums.put(k, new ArrayList<>());
            rightSums.put(k, new ArrayList<>());
        }

        // Submask DP generation for left and right
        for (int mask = 0; mask < (1 << n); mask++) {
            int sz = Integer.bitCount(mask);
            int lSum = 0, rSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lSum += left[i];
                    rSum += right[i];
                }
            }
            leftSums.get(sz).add(lSum);
            rightSums.get(sz).add(rSum);
        }

        for (int k = 0; k <= n; k++) {
            Collections.sort(rightSums.get(k));
        }

        int minDiff = Integer.MAX_VALUE;
        int target = sum / 2;

        for (int k = 0; k <= n; k++) {
            List<Integer> lList = leftSums.get(k);
            List<Integer> rList = rightSums.get(n - k);

            for (int a : lList) {
                int bTarget = target - a;
                int idx = Collections.binarySearch(rList, bTarget);
                if (idx < 0) idx = -idx - 1;

                if (idx < rList.size()) {
                    int s1 = a + rList.get(idx);
                    minDiff = Math.min(minDiff, Math.abs(sum - 2 * s1));
                }
                if (idx > 0) {
                    int s1 = a + rList.get(idx - 1);
                    minDiff = Math.min(minDiff, Math.abs(sum - 2 * s1));
                }
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 3};
        System.out.println("Minimum Subset Sum Difference: " + minimumDifference(nums));
    }
}