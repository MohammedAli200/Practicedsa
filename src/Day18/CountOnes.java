package Day18;

import java.util.Scanner;

public class CountOnes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int low = 0;
        int high = n - 1;
        int firstOne = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                firstOne = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int count = n - firstOne;

        System.out.println("Number of 1s = " + count);
    }
}