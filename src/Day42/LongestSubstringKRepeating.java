package Day42;

public class LongestSubstringKRepeating {
    public static int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private static int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int nextStart = i + 1;
                while (nextStart < end && count[s.charAt(nextStart) - 'a'] < k) {
                    nextStart++;
                }
                return Math.max(
                        helper(s, start, i, k),
                        helper(s, nextStart, end, k)
                );
            }
        }

        return end - start;
    }

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        System.out.println("Longest Substring Length: " + longestSubstring(s, k));
    }
}