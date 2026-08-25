package Day13;

public class LowerBound {
    static void main() {
        int[] arr={0,0,1,1,1,1,1};
        int low=0,high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]==1) high=mid-1;
            else low=mid+1;
        }
        System.out.println(low);
    }
}
