package Day30;

public class ProductExceptSelf {
    void main(String[] args){
        int[] nums={1,2,3,4};
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for (int j = 0; j <nums.length ; j++) {
//                System.out.print(nums[j]);
                if(i==j) continue;
                else prod*=nums[j];
            }
            res[i]=prod;
        }
    }
}
