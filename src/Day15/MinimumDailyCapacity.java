package Day15;

import java.util.Scanner;

public class MinimumDailyCapacity {

    static boolean possible(
            int[] tasks,
            int days,
            long capacity) {

        int usedDays = 1;
        long current = 0;

        for (int task : tasks) {

            if (task > capacity)
                return false;

            if (current + task > capacity) {

                usedDays++;
                current = task;

            } else {

                current += task;
            }
        }

        return usedDays <= days;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] tasks = new int[n];

        long low = 0;
        long high = 0;

        for (int i = 0; i < n; i++) {

            tasks[i] = sc.nextInt();

            low = Math.max(
                    low, tasks[i]);

            high += tasks[i];
        }

        int days = sc.nextInt();

        long answer = high;

        while (low <= high) {

            long mid =
                    low + (high - low) / 2;

            if (possible(
                    tasks, days, mid)) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}