package Day24;

import java.util.*;

public class Main1 {

    static long repairCars(int[] ranks, int cars) {
        long low = 1;

        int minRank = Integer.MAX_VALUE;

        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }

        long high = (long) minRank * cars * cars;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canRepair(ranks, cars, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static boolean canRepair(int[] ranks, int cars, long time) {
        long repaired = 0;

        for (int r : ranks) {
            repaired += (long) Math.sqrt((double) time / r);

            if (repaired >= cars)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;

        System.out.println(repairCars(ranks, cars));
    }
}