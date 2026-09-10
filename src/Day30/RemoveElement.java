package Day30;

public class RemoveElement {
    void main(String[] args){
        int[] arr={0,1,2,2,3,0,4,2};
        int val=2;
        int count=0,i=0,j=arr.length-1;
        while(i<=j){
            if(arr[i]==val&&arr[j]!=val){
                count++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=arr[i];
                i++;
                j--;
            }
            else if(arr[i]!=val){
                i++;
            }
            else if(arr[j]==val){
                count++;
                j--;
            }
        }
        System.out.println(arr.length-count);
    }
}
