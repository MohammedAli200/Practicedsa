package Day11;

import java.util.Scanner;

public class HIndexBinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] citations = new int[n];

        for (int i = 0; i < n; i++)
            citations[i] = sc.nextInt();

        int low = 0;
        int high = n;

        while (low <= high) {

            int h = low + (high - low) / 2;

            int index = n - h;

            if (index < n && citations[index] >= h) {
                low = h + 1;
            } else {
                high = h - 1;
            }
        }

        System.out.println("H-Index = " + high);
    }
}