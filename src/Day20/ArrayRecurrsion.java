package Day20;

public class ArrayRecurrsion {
    static void main() {
        int[] arr={1,2,3,4,5,6};
        printArr(arr,arr.length-1);
        printRev(arr,arr.length-1);
    }
    static void printArr(int[] arr,int i){
        if(i<0)return;
        printArr(arr,i-1);
        System.out.print(arr[i]+" ");
    }
    static void printRev(int[] arr,int i){
        if(i<0) return;
        System.out.print(arr[i]+" ");
        printRev(arr,i-1);
    }
}
