package Day17;

import java.util.Scanner;

public class RotatedArrayDuplicates {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int low = 0;
        int high = n - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {

                high = mid;

            } else if (nums[mid] > nums[high]) {

                low = mid + 1;

            } else {

                high--;
            }
        }

        System.out.println("Minimum = " + nums[low]);
    }
}