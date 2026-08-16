package Day5;

import java.util.Scanner;

public class FirstOneInfiniteArray {

    static int binarySearch(int[] arr, int low,
                            int high) {

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int low = 0;
        int high = 1;

        while (high < n && arr[high] == 0) {
            low = high;
            high = high * 2;
        }

        high = Math.min(high, n - 1);

        int result = binarySearch(arr, low, high);

        System.out.println("First 1 = " + result);
    }
}