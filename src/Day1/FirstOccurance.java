package Day1;

public class FirstOccurance {
    static void main() {
        int[] arr = {1,1,2,2,2,3,4,5,5,5,6,7,8,11};
        int target=5;
        System.out.print(fOccurance(arr,target));
    }
    static int fOccurance(int[] arr,int target){
        int temp=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<target)
                low=mid+1;
            else if(arr[mid]>target)
                high=mid-1;
            else {
                 temp=mid;
                 high=mid-1;
            }
        }
        return temp;
    }
}
