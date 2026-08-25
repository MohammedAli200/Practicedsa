package Day14;

import java.util.Scanner;

public class AllocatePages {

    static boolean canAllocate(
            int[] pages, int students, long limit) {

        int count = 1;
        long sum = 0;

        for (int page : pages) {

            if (page > limit)
                return false;

            if (sum + page > limit) {
                count++;
                sum = page;
            } else {
                sum += page;
            }
        }

        return count <= students;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] pages = new int[n];

        long low = 0;
        long high = 0;

        for (int i = 0; i < n; i++) {

            pages[i] = sc.nextInt();

            low = Math.max(low, pages[i]);
            high += pages[i];
        }

        int students = sc.nextInt();

        if (students > n) {
            System.out.println("Allocation not possible");
            return;
        }

        long answer = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canAllocate(pages, students, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(
                "Minimum Maximum Pages = " + answer);
    }
}