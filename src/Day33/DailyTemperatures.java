package Day33;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Process elements smaller than current temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temps)));
        // Output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}