package Day15;

import java.util.Scanner;

public class MinimumProductionTime {

    static boolean possible(
            int[] machines,
            long target,
            long time) {

        long produced = 0;

        for (int machine : machines) {

            produced += time / machine;

            if (produced >= target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] machines = new int[n];

        int fastest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            machines[i] = sc.nextInt();

            fastest = Math.min(
                    fastest, machines[i]);
        }

        long target = sc.nextLong();

        long low = 1;
        long high = (long) fastest * target;

        long answer = high;

        while (low <= high) {

            long mid =
                    low + (high - low) / 2;

            if (possible(
                    machines, target, mid)) {

                answer = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}