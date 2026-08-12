package Day1;

public class FindFloor {
    static void main() {
        int[] arr={1,2,8,10,10,12,9};
        int elem=5;
        System.out.print(FFloor(arr,elem));
    }
    static int FFloor(int[] arr,int elem){
        int temp=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>elem) high=mid-1;
            else{
                temp=arr[mid];
                low=mid+1;
            }
        }
        return (temp>-1)?temp:-1;
    }
}
