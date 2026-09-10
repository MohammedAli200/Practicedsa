package Day30;

public class largestAltitude {
    void main(String[] args){
        int[] gain = {-5,1,5,0,-7};
        int[] prefix = new int[gain.length+1];
        prefix[0]=0;
       for(int i=0;i<gain.length;i++){
           prefix[i+1]=prefix[i]+gain[i];
       }
       for(int num:prefix){
           System.out.print(num+" ");
       }
    }
}
