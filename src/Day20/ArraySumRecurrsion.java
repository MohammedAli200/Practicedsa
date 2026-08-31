package Day20;

public class ArraySumRecurrsion {
    static void main() {
        int[] arr={1,2,3,4,5,6};
        int ans=0;
        System.out.println(printSum(arr,arr.length-1,ans));

    }
    static int printSum(int[] arr,int i,int ans){
        if(i<0) return 0;
        ans+=printSum(arr,i-1,ans);
        return ans;
    }
}
