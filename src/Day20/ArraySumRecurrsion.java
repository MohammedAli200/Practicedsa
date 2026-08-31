package Day20;

public class ArraySumRecurrsion {
    static void main() {
        int[] arr={1,2,3,4,5,6};
        System.out.println(printSum(arr,arr.length-1));

    }
    static int printSum(int[] arr,int i){
        if(i<0) return 0;
        return arr[i]+printSum(arr,i-1);
    }
}
