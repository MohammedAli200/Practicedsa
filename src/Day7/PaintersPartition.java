package Day7;

import java.util.Scanner;

public class PaintersPartition {

    static boolean canPaint(int[] boards, int painters, int limit) {

        int painterCount = 1;
        int currentWork = 0;

        for (int board : boards) {

            if (currentWork + board > limit) {
                painterCount++;
                currentWork = 0;
            }

            currentWork += board;

            if (painterCount > painters)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] boards = new int[n];

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {

            boards[i] = sc.nextInt();

            low = Math.max(low, boards[i]);
            high += boards[i];
        }

        int painters = sc.nextInt();

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPaint(boards, painters, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Minimum Maximum Time = " + answer);
    }
}