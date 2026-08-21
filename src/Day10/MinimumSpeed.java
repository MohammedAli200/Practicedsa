package Day10;

import java.util.Scanner;

public class MinimumSpeed {

    static boolean canReach(int[] dist, int speed, double hour) {

        double time = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }

        time += (double) dist[dist.length - 1] / speed;

        return time <= hour;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dist = new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = sc.nextInt();

        double hour = sc.nextDouble();

        int low = 1;
        int high = 10_000_000;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(dist, mid, hour)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Minimum Speed = " + answer);
    }
}