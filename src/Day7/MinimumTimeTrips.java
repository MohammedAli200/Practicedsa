package Day7;

import java.util.Scanner;

public class MinimumTimeTrips {

    static boolean canComplete(
            int[] time, long totalTrips, long limit) {

        long trips = 0;

        for (int t : time) {

            trips += limit / t;

            if (trips >= totalTrips)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] time = new int[n];

        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            time[i] = sc.nextInt();
            minTime = Math.min(minTime, time[i]);
        }

        long totalTrips = sc.nextLong();

        long low = 1;
        long high = (long) minTime * totalTrips;

        long answer = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canComplete(time, totalTrips, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Minimum Time = " + answer);
    }
}