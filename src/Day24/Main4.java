package Day24;

import java.util.*;

public class Main4{

    static int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;

        for (int x : quantities) {
            high = Math.max(high, x);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canDistribute(quantities, n, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static boolean canDistribute(int[] quantities, int n, int maxProducts) {
        long stores = 0;

        for (int q : quantities) {
            stores += (q + maxProducts - 1) / maxProducts;

            if (stores > n)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] quantities = {11, 6};
        int n = 6;

        System.out.println(minimizedMaximum(n, quantities));
    }
}