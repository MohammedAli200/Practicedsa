package Day20;

public class SumOfNumbers {
    static void main() {
        int n=10;
        System.out.println(sum(n));
    }
    static int sum(int n){
        if(n==0) return 0;
        return n+sum(n-1);
    }
}
