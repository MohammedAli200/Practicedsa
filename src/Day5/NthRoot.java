package Day5;

import java.util.Scanner;

public class NthRoot {

    static int comparePower(int base, int n, int target) {

        long result = 1;

        for (int i = 0; i < n; i++) {

            result *= base;

            if (result > target)
                return 1;
        }

        if (result == target)
            return 0;

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int low = 1;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result = comparePower(mid, n, m);

            if (result == 0) {
                System.out.println(
                        "N-th Root = " + mid);
                return;
            }

            if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Exact N-th Root does not exist");
    }
}