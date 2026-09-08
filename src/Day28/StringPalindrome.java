package Day28;

public class StringPalindrome {
    static boolean isPalindrome(String text, int left, int right) {
        if (left >= right) return true;

        if (text.charAt(left) != text.charAt(right))
            return false;

        return isPalindrome(text, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String text = "madam";

        if (isPalindrome(text, 0, text.length() - 1))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}