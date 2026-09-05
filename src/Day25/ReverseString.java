package Day25;

public class ReverseString {
    static String reverse(String text) {
        if (text.isEmpty()) return text;
        return reverse(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("Java")); // avaJ
    }
}