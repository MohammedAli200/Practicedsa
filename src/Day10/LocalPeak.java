package Day10;

import java.util.Scanner;

public class LocalPeak {

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

            if (arr[mid] < arr[mid + 1])
                low = mid + 1;
            else
                high = mid;
        }

        System.out.println("Peak Element = " + arr[low]);
        System.out.println("Index = " + low);
    }
}