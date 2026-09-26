package Day44;

import java.util.ArrayList;
import java.util.List;

public class ConvexHullTrickDP {
    static class Line {
        long m, c;
        Line(long m, long c) {
            this.m = m;
            this.c = c;
        }

        // Returns x-coordinate of intersection point between this line and line 'other'
        double intersect(Line other) {
            return (double) (other.c - this.c) / (this.m - other.m);
        }

        long eval(long x) {
            return m * x + c;
        }
    }

    public static long minCostWithCHT(long[] x, long[] cost) {
        int n = x.length;
        long[] dp = new long[n];
        List<Line> hull = new ArrayList<>();

        // Base case line: m = -2*x[0], c = x[0]^2 + cost[0]
        hull.add(new Line(-2 * x[0], x[0] * x[0] + cost[0]));
        int pointer = 0;

        for (int i = 1; i < n; i++) {
            // Find optimal line for current query x[i]
            while (pointer + 1 < hull.size() &&
                    hull.get(pointer + 1).eval(x[i]) <= hull.get(pointer).eval(x[i])) {
                pointer++;
            }

            dp[i] = x[i] * x[i] + cost[i] + hull.get(pointer).eval(x[i]);
            Line newLine = new Line(-2 * x[i], dp[i] + x[i] * x[i]);

            // Maintain lower convex hull by popping non-optimal lines
            while (hull.size() >= 2) {
                Line l1 = hull.get(hull.size() - 2);
                Line l2 = hull.get(hull.size() - 1);
                if (l2.intersect(newLine) <= l1.intersect(l2)) {
                    hull.remove(hull.size() - 1);
                } else {
                    break;
                }
            }

            hull.add(newLine);
            pointer = Math.min(pointer, hull.size() - 1);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        long[] x = {1, 2, 4, 7, 11};
        long[] cost = {2, 3, 1, 5, 4};
        System.out.println("Minimum DP Cost (CHT): " + minCostWithCHT(x, cost));
    }
}