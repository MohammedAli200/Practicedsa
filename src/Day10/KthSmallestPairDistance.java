package Day10;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestPairDistance {

    static int countPairs(int[] arr, int distance) {

        int count = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {

            while (arr[right] - arr[left] > distance)
                left++;

            count += right - left;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        Arrays.sort(arr);

        int low = 0;
        int high = arr[n - 1] - arr[0];

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (countPairs(arr, mid) >= k)
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(
                "K-th Smallest Distance = " + low);
    }
}