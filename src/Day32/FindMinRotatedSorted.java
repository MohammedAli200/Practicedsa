package Day32;

public class FindMinRotatedSorted {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right element, min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Min is in left half including mid
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Minimum element: " + findMin(nums)); // Output: 1
    }
}