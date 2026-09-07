package Day27;

public class TransformArray {
    static void main() {
        int[] nums={4,3,2,1};
        int eveCou=0;
        int oddCou=0;
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) eveCou++;
            else oddCou++;
        }
        for (int i = 0; i < eveCou; i++) {
            res[i]=0;
        }
        for (int i = eveCou; i < nums.length; i++) {
            res[i]=1;
        }
        for (int num:res){
            System.out.println(num);
        }
    }
}
