package Day10;

import java.util.Scanner;

public class LowerBound {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (answer == -1)
            System.out.println("No element found");
        else
            System.out.println("Ceiling = " + arr[answer]);
    }
}