package Day1;

public class BinarySearch {
    static void main() {
        int[] arr = {12,14,16,18,19,26,30};
        int target=14;
        System.out.print(binary(arr,target));
    }
    static int binary(int[] arr,int target){
        int low=0;
        int high= arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                high=mid-1;
            else if(arr[mid]<target)
                low=mid+1;
        }
        return -1;
    }
}
