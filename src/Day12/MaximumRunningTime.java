package Day12;

import java.util.Scanner;

public class MaximumRunningTime {

    static boolean canRun(
            long[] batteries, int computers, long time) {

        long available = 0;

        for (long battery : batteries) {

            available += Math.min(battery, time);

            if (available >=
                    time * computers)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int computers = sc.nextInt();
        int n = sc.nextInt();

        long[] batteries = new long[n];

        long total = 0;

        for (int i = 0; i < n; i++) {

            batteries[i] = sc.nextLong();
            total += batteries[i];
        }

        long low = 0;
        long high = total / computers;

        while (low < high) {

            long mid =
                    low + (high - low + 1) / 2;

            if (canRun(batteries, computers, mid))
                low = mid;
            else
                high = mid - 1;
        }

        System.out.println(
                "Maximum Running Time = " + low);
    }
}