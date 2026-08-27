package Day16;

import java.util.Scanner;

public class RangeCount {

    static int lowerBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    static int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int left = sc.nextInt();
        int right = sc.nextInt();

        int start = lowerBound(arr, left);
        int end = upperBound(arr, right);

        System.out.println("Count = " + (end - start));
    }
}