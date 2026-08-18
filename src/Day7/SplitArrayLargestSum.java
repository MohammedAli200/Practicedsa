package Day7;

import java.util.Scanner;

public class SplitArrayLargestSum {

    static boolean canSplit(
            int[] arr, int k, int limit) {

        int parts = 1;
        int currentSum = 0;

        for (int num : arr) {

            if (currentSum + num > limit) {
                parts++;
                currentSum = 0;
            }

            currentSum += num;

            if (parts > k)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        int k = sc.nextInt();

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canSplit(arr, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(
                "Minimum Largest Sum = " + answer);
    }
}