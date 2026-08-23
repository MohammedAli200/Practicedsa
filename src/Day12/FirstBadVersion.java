package Day12;

import java.util.Scanner;

public class FirstBadVersion {

    static int firstBadVersion(int n, int bad) {

        int low = 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (mid >= bad)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int bad = sc.nextInt();

        System.out.println(
                "First Bad Version = " +
                        firstBadVersion(n, bad));
    }
}