package Day24;

import java.util.*;

public class Main3 {

    static int maximizeSweetness(int[] sweetness, int k) {
        int low = 1;
        int high = 0;

        for (int x : sweetness) {
            high += x;
        }

        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDivide(sweetness, k + 1, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    static boolean canDivide(int[] sweetness, int pieces, int minSweetness) {
        int sum = 0;
        int count = 0;

        for (int x : sweetness) {
            sum += x;

            if (sum >= minSweetness) {
                count++;
                sum = 0;
            }
        }

        return count >= pieces;
    }

    public static void main(String[] args) {
        int[] sweetness = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 5;

        System.out.println(maximizeSweetness(sweetness, k));
    }
}