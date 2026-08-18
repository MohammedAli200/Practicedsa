package Day7;

import java.util.Scanner;

public class MaximumRemovals {

    static boolean isSubsequence(
            String s, String p, int[] removable, int k) {

        boolean[] removed = new boolean[s.length()];

        for (int i = 0; i < k; i++)
            removed[removable[i]] = true;

        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            if (!removed[i] &&
                    j < p.length() &&
                    s.charAt(i) == p.charAt(j)) {

                j++;
            }
        }

        return j == p.length();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String p = sc.next();

        int n = sc.nextInt();

        int[] removable = new int[n];

        for (int i = 0; i < n; i++)
            removable[i] = sc.nextInt();

        int low = 0;
        int high = n;
        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isSubsequence(s, p, removable, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Maximum Removals = " + answer);
    }
}