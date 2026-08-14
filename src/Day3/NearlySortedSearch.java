package Day3;

import java.util.Scanner;

public class NearlySortedSearch {

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
                System.out.println("Element found at index = " + mid);
                return;
            }

            if (mid - 1 >= low && arr[mid - 1] == target) {
                System.out.println("Element found at index = " + (mid - 1));
                return;
            }

            if (mid + 1 <= high && arr[mid + 1] == target) {
                System.out.println("Element found at index = " + (mid + 1));
                return;
            }

            if (arr[mid] > target)
                high = mid - 2;
            else
                low = mid + 2;
        }

        System.out.println("Element not found");
    }
}