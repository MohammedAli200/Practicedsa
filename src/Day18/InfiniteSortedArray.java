package Day18;

import java.util.Scanner;

public class InfiniteSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int low = 0;
        int high = 1;

        // Expand the range
        while (high < n && arr[high] < target) {

            low = high + 1;
            high = high * 2;

            if (high >= n)
                high = n - 1;
        }

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                System.out.println("Index = " + mid);
                return;
            }

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Index = -1");
    }
}