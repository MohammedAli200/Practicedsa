package Day31;

public class GCDExample {
    // Recursive method to find GCD using Euclidean algorithm
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        int num1 = 60, num2 = 36;
        int gcd = findGCD(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        // Output: GCD of 60 and 36 is: 12
    }
}

