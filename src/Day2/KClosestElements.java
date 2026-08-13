package Day2;

import java.util.Scanner;

public class KClosestElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();
        int target = sc.nextInt();

        int low = 0;
        int high = n - k;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (target - arr[mid] >
                    arr[mid + k] - target) {

                low = mid + 1;

            } else {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}