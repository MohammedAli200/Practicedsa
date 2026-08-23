package Day12;

import java.util.Scanner;

public class FindDuplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n + 1];

        for (int i = 0; i <= n; i++)
            nums[i] = sc.nextInt();

        int low = 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            for (int num : nums) {
                if (num <= mid)
                    count++;
            }

            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println("Duplicate = " + low);
    }
}