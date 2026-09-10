package Day30;

public class SumofSquares {
    void main() {
        int[] nums={1,2,3,4};
        int res=0;
        int k=nums.length;
        for(int i=0;i<nums.length;i++){
            if(k%(i+1)==0){
                res+=square(nums[i]);

            }
        }
        System.out.println(res);
    }
    public int square(int n){
        return n*n;
    }

}
