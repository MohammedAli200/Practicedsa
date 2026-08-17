package Day6;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

    static boolean canPlace(
            int[] stalls, int cows, int distance) {

        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= distance) {

                count++;
                lastPosition = stalls[i];

                if (count >= cows)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stalls = new int[n];

        for (int i = 0; i < n; i++)
            stalls[i] = sc.nextInt();

        int cows = sc.nextInt();

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n - 1] - stalls[0];

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlace(stalls, cows, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(
                "Maximum Minimum Distance = " + answer);
    }
}