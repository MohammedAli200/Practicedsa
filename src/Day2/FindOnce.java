package Day2;

public class FindOnce {
    static void main() {
        int[] arr={1,1,2,2,3,3,4,50,50,65};
        System.out.print(OneOccur(arr));
    }
    static int OneOccur(int[] arr){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid-1]!=arr[mid]&&arr[mid+1]!=arr[mid]) return mid;
            else{
                if(arr[mid]==arr[mid-1]){
                    if((low+mid-1)%2==0)
                        low=mid+1;
                }
                if(arr[mid]==arr[mid+1]){
                    if((high+(mid+1))%2==0)
                        high=mid-1;
                }
            }
        }
        return -1;
    }
}
