package Day3;

import java.util.Scanner;

public class InfiniteArraySearch {

    static int binarySearch(
            int[] arr, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        int low = 0;
        int high = 1;

        while (high < n && arr[high] < target) {

            low = high;
            high = high * 2;
        }

        high = Math.min(high, n - 1);

        int result = binarySearch(
                arr, low, high, target);

        if (result != -1)
            System.out.println(
                    "Element found at index = " + result);
        else
            System.out.println("Element not found");
    }
}