package Day16;

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

        if (low == 0) {
            System.out.println(
                    "Closest Element = " + arr[0]);
        }
        else if (low == n) {
            System.out.println(
                    "Closest Element = " + arr[n - 1]);
        }
        else {

            int left = arr[low - 1];
            int right = arr[low];

            if (target - left <= right - target)
                System.out.println(
                        "Closest Element = " + left);
            else
                System.out.println(
                        "Closest Element = " + right);
        }
    }
}