package Day26;

public class ProductOfDigits {
    static int productDigits(int n) {
        if (n == 0) return 1;
        return (n % 10) * productDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(productDigits(234)); // 24
    }
}