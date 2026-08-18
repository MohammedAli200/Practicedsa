package Day7;

import java.util.Scanner;

public class RepairCars {

    static boolean canRepair(
            int[] ranks, int cars, long time) {

        long repaired = 0;

        for (int rank : ranks) {

            long maxCars =
                    (long) Math.sqrt((double) time / rank);

            repaired += maxCars;

            if (repaired >= cars)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ranks = new int[n];

        int minRank = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            ranks[i] = sc.nextInt();
            minRank = Math.min(minRank, ranks[i]);
        }

        int cars = sc.nextInt();

        long low = 0;
        long high = (long) minRank * cars * cars;

        long answer = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canRepair(ranks, cars, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(
                "Minimum Repair Time = " + answer);
    }
}