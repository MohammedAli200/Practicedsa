package Day30;

public class FlipAndInvertImage {
     void main() {
        int[][] arr={{1,1,0},{1,0,1},{0,0,0}};
        int n=arr.length;
        int m=arr[0].length;
        int[][] res=new int[n][m];
        for(int i=0;i<n;i++){
            res[i]=revArray(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(res[j]);
            }
            System.out.println();
        }
    }
    public int[] revArray(int[] arr){
        int i=0,j=arr.length-1;
        while(i<=j){
            if(arr[i]==0) arr[i]=1;
            else arr[i]=0;
            if(arr[j]==0) arr[j]=1;
            else arr[j]=0;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return arr;
    }
}
