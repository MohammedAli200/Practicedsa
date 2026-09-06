package Day26;

public class Palindrome {
    static int reverse(int n, int rev) {
        if (n == 0) return rev;
        return reverse(n / 10, rev * 10 + n % 10);
    }

    public static void main(String[] args) {
        int number = 121;
        int reversed = reverse(number, 0);

        if (number == reversed)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}