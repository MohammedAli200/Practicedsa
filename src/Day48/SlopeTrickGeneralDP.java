package Day48;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlopeTrickGeneralDP {
    private long minVal = 0;
    private final PriorityQueue<Long> leftMax = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Long> rightMin = new PriorityQueue<>();

    // Adds absolute penalty |x - a| to continuous convex function
    public void addAbsPenalty(long a) {
        if (!leftMax.isEmpty() && a < leftMax.peek()) {
            minVal += leftMax.peek() - a;
            leftMax.add(a);
            rightMin.add(leftMax.poll());
            leftMax.add(a);
        } else if (!rightMin.isEmpty() && a > rightMin.peek()) {
            minVal += a - rightMin.peek();
            rightMin.add(a);
            leftMax.add(rightMin.poll());
            rightMin.add(a);
        } else {
            leftMax.add(a);
            rightMin.add(a);
        }
    }

    public long getMinimumCost() {
        return minVal;
    }

    public static void main(String[] args) {
        SlopeTrickGeneralDP st = new SlopeTrickGeneralDP();
        long[] targets = {4, 1, 8, 2, 6};

        for (long t : targets) {
            st.addAbsPenalty(t);
        }

        System.out.println("Minimum Total Cost (Slope Trick DP): " + st.getMinimumCost());
    }
}