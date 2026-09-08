package Day28;

public class RecursiveBinarySearch {
    static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == key) return mid;
        if (key < arr[mid])
            return binarySearch(arr, low, mid - 1, key);

        return binarySearch(arr, mid + 1, high, key);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12};
        int position = binarySearch(arr, 0, arr.length - 1, 8);

        System.out.println("Element found at index: " + position); // 3
    }
}