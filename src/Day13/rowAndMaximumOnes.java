package Day13;

public class rowAndMaximumOnes {
    static void main() {
        int[][] mat={{0,1},{1,0}};
        int n=mat.length;
        int m=mat[0].length;
        int maxCount=-1;
        int idx=-1;
        int[] arr=new int[2];
        for(int i=0;i<n;i++){
            int count=m-lowerbound(mat[i],1);
            System.out.println(count);
            if(count>maxCount){
                maxCount=count;
                idx=i;
            }
        }
        arr[0]=idx;
        arr[1]=maxCount;
        System.out.println(arr[0]+" "+arr[1]);

    }
    public static int lowerbound(int[] arr,int x){
        int low=0,high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]==1) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}
