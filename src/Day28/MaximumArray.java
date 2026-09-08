package Day28;

public class MaximumArray {
    static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];

        return Math.max(arr[index], findMax(arr, index + 1));
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 12, 1, 6};
        System.out.println(findMax(arr, 0)); // 12
    }
}