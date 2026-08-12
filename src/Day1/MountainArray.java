package Day1;

public class MountainArray {
    static void main() {
        int[] arr={-1,0,1,2,5,6,7,8,6,3};
        System.out.print(MountainEle(arr));
    }
    static int MountainEle(int[] arr){
        int elem=-1;
        int low=0;
        int high=arr.length-2;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1])
                return arr[mid];
            else if(arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1]){
                low=mid+1;
            }
            else if(arr[mid]>arr[mid+1]&&arr[mid]<arr[mid-1]){
                high=mid-1;
            }
        }
        return elem;
    }
}
