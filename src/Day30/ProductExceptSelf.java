package Day30;
import java.util.Arrays;
public class ProductExceptSelf {
    void main(String[] args){
        int[] nums = {-1, 1, 0, -3, 3};
        int[] res = productExceptSelf(nums);

        // Printing output correctly using Arrays.toString
        System.out.println(Arrays.toString(res));
    }
    public  int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Calculate prefix products (left to right)
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(res));
        // Step 2: Multiply by suffix products (right to left)
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i]; // Update suffix product for next iteration
        }

        return res;
    }
}
