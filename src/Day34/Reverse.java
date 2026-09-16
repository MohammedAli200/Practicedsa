package Day34;

public class Reverse {
    static void main() {
        int num=12321;
        System.out.println(feq(num,1));
    }
    static int rev(int num){
        int rev=Integer.MAX_VALUE;
        while(num>0) {
            int digit=num%10;
            if(digit<rev) rev=digit;
            num /= 10;
        }
        return rev;
    }
    static int feq(int num,int dig){
        int c=0;
        while(num>0){
            int rem=num%10;
            if(rem==dig) c++;
            num/=10;
        }
        return c;
    }
}
