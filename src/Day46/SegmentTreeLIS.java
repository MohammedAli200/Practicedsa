package Day46;

import java.util.Arrays;

public class SegmentTreeLIS {
    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = Math.max(tree[node], val);
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) update(2 * node, start, mid, idx, val);
            else update(2 * node + 1, mid + 1, end, idx, val);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l || l > r) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return Math.max(query(2 * node, start, mid, l, r),
                    query(2 * node + 1, mid + 1, end, l, r));
        }
    }

    public static int findLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        SegmentTree segTree = new SegmentTree(n);
        int maxLIS = 0;

        for (int num : nums) {
            int rank = Arrays.binarySearch(sorted, num) + 1;
            int bestPrev = segTree.query(1, 1, n, 1, rank - 1);
            int currentLIS = bestPrev + 1;

            segTree.update(1, 1, n, rank, currentLIS);
            maxLIS = Math.max(maxLIS, currentLIS);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS Length (Segment Tree DP): " + findLIS(nums));
    }
}