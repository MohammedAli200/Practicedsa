package Day10;

import java.util.Scanner;

public class NextGreatestLetter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] letters = new char[n];

        for (int i = 0; i < n; i++)
            letters[i] = sc.next().charAt(0);

        char target = sc.next().charAt(0);

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (letters[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println(
                "Next Character = " + letters[low % n]);
    }
}