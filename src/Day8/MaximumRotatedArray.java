package Day8;

import java.util.Scanner;

public class MaximumRotatedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int low = 0;
        int high = n - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[high])
                high = mid;
            else
                low = mid + 1;
        }

        int minIndex = low;
        int maxIndex = (minIndex - 1 + n) % n;

        System.out.println(
                "Maximum Element = " + arr[maxIndex]);
    }
}