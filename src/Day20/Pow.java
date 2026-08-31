package Day20;

public class Pow {
    static void main() {
        int n=10;
        System.out.println(pow(n,2));
    }
    static int pow(int n,int x){
        if(x==0) return 1;
        return n*pow(n,x-1);
    }
}
