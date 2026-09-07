package Day27;

public class LeftRightDifference {
    static void main() {
        int[] arr={10,4,8,3};
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        int[] res=new int[arr.length];
        left[0]=0;
        right[arr.length-1]=0;
        for (int i = 1; i < arr.length; i++) {
            left[i]=left[i-1]+arr[i-1];

        }
        for (int i = arr.length-2; i >=0 ; i--) {
            right[i]=right[i+1]+arr[i+1];

        }
        for(int i=0;i<arr.length;i++){
            res[i]=Math.abs(left[i]-right[i]);
        }
        for(int nums:res){
            System.out.println(nums);
        }
    }
}
