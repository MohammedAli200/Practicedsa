package Day19;

import java.util.Scanner;

public class MajorityElementSorted {

    static int firstOccurrence(
            int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                answer = mid;
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        int first = firstOccurrence(arr, target);

        if (first != -1 &&
                first + n / 2 < n &&
                arr[first + n / 2] == target) {

            System.out.println(
                    "Majority Element Exists");

        } else {

            System.out.println(
                    "Majority Element Does Not Exist");
        }
    }
}