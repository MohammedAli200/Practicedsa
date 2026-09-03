package Day23;

import java.util.Scanner;

public class ShipPackages {

    static boolean canShip(
            int[] weights,
            int days,
            int capacity) {

        int current = 0;
        int usedDays = 1;

        for (int weight : weights) {

            if (current + weight > capacity) {
                usedDays++;
                current = 0;
            }

            current += weight;

            if (usedDays > days)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] weights = new int[n];

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {

            weights[i] = sc.nextInt();

            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        int days = sc.nextInt();

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(
                "Minimum Capacity = " + answer);
    }
}