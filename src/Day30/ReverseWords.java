package Day30;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(new StringBuilder(words[i]).reverse());
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());
    }
}