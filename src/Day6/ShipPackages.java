package Day6;

import java.util.Scanner;

public class ShipPackages {

    static boolean canShip(
            int[] weights, int capacity, int days) {

        int currentWeight = 0;
        int requiredDays = 1;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = 0;
            }

            currentWeight += weight;

            if (requiredDays > days)
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

            if (canShip(weights, mid, days)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Minimum Capacity = " + answer);
    }
}