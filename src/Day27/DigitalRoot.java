package Day27;

public class DigitalRoot {
    static void main() {
        int n=80677;
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        System.out.println(sum);
        if(sum<10) System.out.println(sum);
        else {
            int rsum = 0;
            while (sum!=0) {
                rsum += sum % 10;
                sum /= 10;
            }
            System.out.println(rsum);
        }
    }
}
