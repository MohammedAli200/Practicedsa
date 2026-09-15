package Day34;

public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in left sorted half
                } else {
                    left = mid + 1;  // Target is in right half
                }
            }
            // Otherwise, right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target is in right sorted half
                } else {
                    right = mid - 1; // Target is in left half
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index of target: " + search(nums, target)); // Output: 4
    }
}