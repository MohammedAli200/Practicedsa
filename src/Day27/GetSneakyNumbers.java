package Day27;

public class GetSneakyNumbers {
    static void main() {
        int[] nums = {0,1,1,0};
        int[] res=new int[2];
        int count=0;
        for(int i=0;i<nums.length&&count<2;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    res[count]=nums[i];
                    count++;
                }
            }
        }
        for(int num:res){
            System.out.println(num);
        }
    }
}
