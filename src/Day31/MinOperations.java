package Day31;

public class MinOperations {
    void main(String[] args){
        int[] arr={1,5,2,4,1};
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<=arr[i-1]){
                int diff=arr[i-1]-arr[i];
                arr[i]+=diff+1;
                count+=(diff+1);

                System.out.println(count+" "+arr[i]);
            }
        }
        System.out.println(count);
    }
}
