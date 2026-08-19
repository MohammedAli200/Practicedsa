package Day8;

import java.util.Scanner;

public class MinimumDifferenceElement {

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
                System.out.println("Closest Element = " + arr[mid]);
                System.out.println("Minimum Difference = 0");
                return;
            }

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        int closest;

        if (high < 0) {
            closest = arr[low];
        } else if (low >= n) {
            closest = arr[high];
        } else {

            int leftDifference =
                    Math.abs(arr[high] - target);

            int rightDifference =
                    Math.abs(arr[low] - target);

            if (leftDifference <= rightDifference)
                closest = arr[high];
            else
                closest = arr[low];
        }

        System.out.println("Closest Element = " + closest);
        System.out.println(
                "Minimum Difference = "
                        + Math.abs(closest - target));
    }
}