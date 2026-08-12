package Day1;

public class RevBinarySearch {
    static void main() {
        int[] arr={100,91,87,76,66,52,43,35,29,13,5};
        int tar=76;
        System.out.print(revBinSea(arr,tar));
    }
    static int revBinSea(int[] arr,int tar){
        int idx=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>tar)
                low=mid+1;
            else if (arr[mid]<tar)
                high=mid-1;
            else
                return mid;
        }
        return idx;
    }
}
