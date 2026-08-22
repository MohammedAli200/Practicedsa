package Day11;

import java.util.Scanner;

public class BitonicArraySearch {

    static int findPeak(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1])
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    static int ascendingSearch(
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

    static int descendingSearch(
            int[] arr, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target)
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

        int peak = findPeak(arr);

        int result = ascendingSearch(
                arr, 0, peak, target);

        if (result == -1) {
            result = descendingSearch(
                    arr, peak + 1, n - 1, target);
        }

        System.out.println("Index = " + result);
    }
}