package Day23;

import java.util.Scanner;

public class AllocatePages {

    static boolean possible(
            int[] pages,
            int students,
            long limit) {

        long current = 0;
        int count = 1;

        for (int page : pages) {

            if (current + page > limit) {

                count++;
                current = page;

            } else {
                current += page;
            }

            if (count > students)
                return false;
        }

        return true;
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
            System.out.println("-1");
            return;
        }

        long answer = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (possible(pages, students, mid)) {

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