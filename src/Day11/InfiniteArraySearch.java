package Day11;

import java.util.Scanner;

public class InfiniteArraySearch {

    static int search(int[] arr, int target) {

        int low = 0;
        int high = 1;

        while (high < arr.length && arr[high] < target) {
            low = high + 1;
            high = high * 2;

            if (high >= arr.length)
                high = arr.length - 1;
        }

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

        int index = search(arr, target);

        System.out.println("Index = " + index);
    }
}