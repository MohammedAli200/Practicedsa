package Day40;

import java.util.Arrays;

public class JobScheduling {
    static class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int inclProfit = jobs[i].profit;
            int lastNonOverlapping = binarySearch(jobs, i);
            if (lastNonOverlapping != -1) {
                inclProfit += dp[lastNonOverlapping];
            }
            dp[i] = Math.max(dp[i - 1], inclProfit);
        }

        return dp[n - 1];
    }

    private static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] start = {1, 2, 3, 3};
        int[] end = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println("Maximum Profit: " + jobScheduling(start, end, profit));
    }
}