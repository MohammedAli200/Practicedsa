package Day28;

public class PrimeCheck {
    static boolean isPrime(int n, int divisor) {
        if (n < 2) return false;
        if (divisor * divisor > n) return true;
        if (n % divisor == 0) return false;

        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        int number = 29;

        if (isPrime(number, 2))
            System.out.println(number + " is Prime");
        else
            System.out.println(number + " is Not Prime");
    }
}