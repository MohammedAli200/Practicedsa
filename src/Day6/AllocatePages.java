package Day6;

import java.util.Scanner;

public class AllocatePages {

    static boolean canAllocate(
            int[] pages, int students, int limit) {

        int studentCount = 1;
        int currentPages = 0;

        for (int page : pages) {

            if (currentPages + page > limit) {
                studentCount++;
                currentPages = 0;
            }

            currentPages += page;

            if (studentCount > students)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] pages = new int[n];

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {

            pages[i] = sc.nextInt();

            low = Math.max(low, pages[i]);
            high += pages[i];
        }

        int students = sc.nextInt();

        if (students > n) {
            System.out.println("Allocation Not Possible");
            return;
        }

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

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