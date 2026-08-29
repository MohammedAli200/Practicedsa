package Day18;

import java.util.Scanner;

public class FirstOneInfiniteArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int low = 0;
        int high = 1;

        while (high < n && arr[high] == 0) {

            low = high + 1;
            high = high * 2;

            if (high >= n)
                high = n - 1;
        }

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("First 1 Index = " + answer);
    }
}