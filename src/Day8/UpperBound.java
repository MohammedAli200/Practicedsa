package Day8;

import java.util.Scanner;

public class UpperBound {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int answer = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (answer == n) {
            System.out.println("No greater element exists");
        } else {
            System.out.println(
                    "First Greater Element = " + arr[answer]);
            System.out.println("Index = " + answer);
        }
    }
}