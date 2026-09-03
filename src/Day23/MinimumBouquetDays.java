package Day23;

import java.util.Scanner;

public class MinimumBouquetDays {

    static boolean possible(
            int[] bloomDay,
            int bouquets,
            int flowers,
            int day) {

        int consecutive = 0;
        int made = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                consecutive++;

                if (consecutive == flowers) {

                    made++;
                    consecutive = 0;
                }

            } else {
                consecutive = 0;
            }
        }

        return made >= bouquets;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] bloomDay = new int[n];

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            bloomDay[i] = sc.nextInt();

            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        int m = sc.nextInt();
        int k = sc.nextInt();

        if ((long) m * k > n) {
            System.out.println(
                    "Minimum Days = -1");
            return;
        }

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(
                    bloomDay, m, k, mid)) {

                answer = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        System.out.println(
                "Minimum Days = " + answer);
    }
}