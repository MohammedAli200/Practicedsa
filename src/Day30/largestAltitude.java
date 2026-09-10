package Day30;

public class largestAltitude {
    void main(String[] args){
        int[] gain = {-5,1,5,0,-7};
        int[] prefix = new int[gain.length+1];
        prefix[0]=0;
        for (int i = 1; i <prefix.length ; i++) {
            prefix[i]+=gain[i-1];
        }
        for(int num:prefix){
            System.out.print(num+" ");
        }
    }
}
