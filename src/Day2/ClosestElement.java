package Day2;

import java.util.Scanner;

public class ClosestElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                System.out.println(
                        "Closest Element = " + arr[mid]);
                return;
            }

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (high < 0) {
            System.out.println(
                    "Closest Element = " + arr[low]);
        }
        else if (low >= n) {
            System.out.println(
                    "Closest Element = " + arr[high]);
        }
        else {

            int leftDiff = Math.abs(arr[high] - target);
            int rightDiff = Math.abs(arr[low] - target);

            if (leftDiff <= rightDiff)
                System.out.println(
                        "Closest Element = " + arr[high]);
            else
                System.out.println(
                        "Closest Element = " + arr[low]);
        }
    }
}