package Day30;

public class pivotIndex {
    static void main() {
        int[] nums={1,7,3,6,5,6};
        int[] leftSum=new int[nums.length];
        int[] rigthSum=new int[nums.length];
        leftSum[0]=nums[0];
        rigthSum[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
                leftSum[i]=nums[i]+leftSum[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            rigthSum[i]=nums[i]+rigthSum[i+1];
        }
        for (int num:rigthSum){
            System.out.print(num+" ");
        }
    }
}
