package Day11;

import java.util.Scanner;

public class MaximumBouquets {

    static boolean canMake(
            int[] flowers, int bouquetSize, long bouquets) {

        long total = 0;

        for (int flower : flowers) {

            total += flower / bouquetSize;

            if (total >= bouquets)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] flowers = new int[n];

        int totalFlowers = 0;

        for (int i = 0; i < n; i++) {
            flowers[i] = sc.nextInt();
            totalFlowers += flowers[i];
        }

        int bouquetSize = sc.nextInt();

        int low = 0;
        int high = totalFlowers / bouquetSize;

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(flowers, bouquetSize, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(
                "Maximum Bouquets = " + answer);
    }
}