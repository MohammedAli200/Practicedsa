package Day47;

import java.util.TreeMap;

public class DynamicConvexHullTrickDP {
    static class Line implements Comparable<Line> {
        long m, c;
        double xIntersect;

        Line(long m, long c) {
            this.m = m;
            this.c = c;
            this.xIntersect = Double.NEGATIVE_INFINITY;
        }

        @Override
        public int compareTo(Line o) {
            return Long.compare(this.m, o.m);
        }
    }

    private final TreeMap<Long, Line> lines = new TreeMap<>();

    private double intersect(Line l1, Line l2) {
        return (double) (l2.c - l1.c) / (l1.m - l2.m);
    }

    public void addLine(long m, long c) {
        Line l = new Line(m, c);
        Long prevSlope = lines.floorKey(m);
        Long nextSlope = lines.ceilingKey(m);

        if (prevSlope != null && lines.get(prevSlope).c >= c && prevSlope == m) return;

        lines.put(m, l);

        // Remove redundant lines to the right
        while (true) {
            Long higherKey = lines.higherKey(m);
            if (higherKey == null) break;
            Line higher = lines.get(higherKey);
            Long afterHigherKey = lines.higherKey(higherKey);

            if (afterHigherKey != null && intersect(l, lines.get(afterHigherKey)) <= intersect(l, higher)) {
                lines.remove(higherKey);
            } else {
                higher.xIntersect = intersect(l, higher);
                break;
            }
        }
    }

    public long query(long x) {
        // Find line with optimal slope using binary search on map
        long maxVal = Long.MIN_VALUE;
        for (Line l : lines.values()) {
            maxVal = Math.max(maxVal, l.m * x + l.c);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        DynamicConvexHullTrickDP cht = new DynamicConvexHullTrickDP();
        cht.addLine(2, 3);
        cht.addLine(3, 1);
        cht.addLine(-1, 8);

        System.out.println("Max output for x = 2: " + cht.query(2));
        System.out.println("Max output for x = 5: " + cht.query(5));
    }
}