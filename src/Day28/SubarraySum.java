package Day28;

public class SubarraySum {
    static void main() {
        int[] nums={2,3,1};
        int res=0;
        for(int i=0;i<nums.length;i++){
            int reres=0;
            for(int j=0;j<=i;j++){
                reres+=nums[j];
            }
            res+=reres;
            System.out.println(res);
        }
        System.out.println(res);
    }
}
