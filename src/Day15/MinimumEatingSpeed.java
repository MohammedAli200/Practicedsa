package Day15;

import java.util.Scanner;

public class MinimumEatingSpeed {

    static boolean canFinish(
            int[] piles, int speed, int hours) {

        long required = 0;

        for (int pile : piles) {

            required += (pile + speed - 1) / speed;

            if (required > hours)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] piles = new int[n];

        int high = 0;

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
            high = Math.max(high, piles[i]);
        }

        int hours = sc.nextInt();

        int low = 1;
        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(piles, mid, hours)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}