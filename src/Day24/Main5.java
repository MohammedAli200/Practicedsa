package Day24;

import java.util.*;

public class Main5 {

    static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int low = 0;
        int high = price[price.length - 1] - price[0];

        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canChoose(price, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    static boolean canChoose(int[] price, int k, int distance) {
        int count = 1;
        int last = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - last >= distance) {
                count++;
                last = price[i];

                if (count >= k)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3;

        System.out.println(maximumTastiness(price, k));
    }
}