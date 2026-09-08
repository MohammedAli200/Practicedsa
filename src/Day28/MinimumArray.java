package Day28;

public class MinimumArray {
    static int findMin(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];

        return Math.min(arr[index], findMin(arr, index + 1));
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 12, 1, 6};
        System.out.println(findMin(arr, 0)); // 1
    }
}