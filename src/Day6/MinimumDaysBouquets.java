package Day6;

import java.util.Scanner;

public class MinimumDaysBouquets {

    static boolean canMake(int[] flowers, int m, int k, int days) {

        int bouquets = 0;
        int consecutive = 0;

        for (int flower : flowers) {

            if (flower <= days) {
                consecutive++;

                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }

            if (bouquets >= m)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] flowers = new int[n];

        int high = 0;

        for (int i = 0; i < n; i++) {
            flowers[i] = sc.nextInt();
            high = Math.max(high, flowers[i]);
        }

        int m = sc.nextInt();
        int k = sc.nextInt();

        if ((long) m * k > n) {
            System.out.println("Impossible");
            return;
        }

        int low = 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(flowers, m, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Minimum Days = " + answer);
    }
}