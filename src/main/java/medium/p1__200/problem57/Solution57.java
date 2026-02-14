package medium.p1__200.problem57;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution57 {

    private static int[][] intervals;
    private static int[] newInterval;
    private static int[][] expected;

    public static int[][] insertTest(int[][] intervals, int[] newInterval) {
        Solution57.Solution1 solution1 = new Solution57.Solution1();
        return solution1.insert(intervals, newInterval);
    }

    public static void main(String[] args) {
        Solution57.Solution1 solution1 = new Solution57.Solution1();

        intervals =
            new int[][] {{1, 3}, {6, 9} };
        newInterval =
            new int[] {2, 5};
        expected =
            new int[][] {{1, 5}, {6, 9} };
        assertArrayEquals(expected, solution1.insert(intervals, newInterval));
        assertArrayEquals(expected, insertTest(intervals, newInterval));

        intervals =
            new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16} };
        newInterval =
            new int[] {4, 9};
        expected =
            new int[][] {{1, 2}, {3, 10}, {12, 16}};
        assertArrayEquals(expected, solution1.insert(intervals, newInterval));
        assertArrayEquals(expected, insertTest(intervals, newInterval));
    }

    public static class Solution1 {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();
            int i = 0;
            // add all the intervals ending before newInterval starts
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                list.add(intervals[i++]);
            }
            // merge all overlapping intervals to one considering newInterval
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                newInterval =
                    new int[] {
                        Math.min(newInterval[0], intervals[i][0]),
                        Math.max(newInterval[1], intervals[i][1])
                    };
                i++;
            }
            list.add(newInterval);
            // add all the rest
            while (i < intervals.length) {
                list.add(intervals[i++]);
            }
            return list.toArray(new int[list.size()][]);
        }
    }

    public static class Solution2 {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] newIntervals = new int[intervals.length + 1][2];
            for (int i = 0; i < intervals.length; ++i) {
                newIntervals[i] = intervals[i];
            }
            newIntervals[intervals.length] = newInterval;
            return merge(newIntervals);
        }

        private int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> ans = new ArrayList<>();
            ans.add(intervals[0]);
            for (int i = 1; i < intervals.length; ++i) {
                int s = intervals[i][0], e = intervals[i][1];
                if (ans.get(ans.size() - 1)[1] < s) {
                    ans.add(intervals[i]);
                } else {
                    ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], e);
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }

    public static class Solution3 {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans = new ArrayList<>();
            int st = newInterval[0], ed = newInterval[1];
            boolean insert = false;
            for (int[] interval : intervals) {
                int s = interval[0], e = interval[1];
                if (ed < s) {
                    if (!insert) {
                        ans.add(new int[] {st, ed});
                        insert = true;
                    }
                    ans.add(interval);
                } else if (e < st) {
                    ans.add(interval);
                } else {
                    st = Math.min(st, s);
                    ed = Math.max(ed, e);
                }
            }
            if (!insert) {
                ans.add(new int[] {st, ed});
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
}
