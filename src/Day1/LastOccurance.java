package Day1;

public class LastOccurance {
    static void main() {
        int[] arr = {1,1,2,2,2,3,4,5,5,5,6,7,8,11};
        int target=2;
        System.out.print(lOccurance(arr,target));
    }
    static int lOccurance(int[] arr,int target){
        int idx=-1;
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<target)
                low=mid+1;
            else if(arr[mid]>target)
                high=mid-1;
            else{
                idx=mid;
                low=mid+1;
            }
        }
        return idx;
    }
}
