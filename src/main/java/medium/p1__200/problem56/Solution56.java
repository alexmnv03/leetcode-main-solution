package medium.p1__200.problem56;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    private static int[][] intervals;
    private static int[][] expected;

    public static int[][] mergeTest(int[][] intervals) {
        Solution56.Solution3 solution3 = new Solution56.Solution3();
        return solution3.merge(intervals);
    }

    public static void main(String[] args) {
        Solution56.Solution3 solution3 = new Solution56.Solution3();

        intervals =
            new int[][] {{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4} };
        expected =
            new int[][] {{2, 4}, {5, 5} };
        assertArrayEquals(expected, solution3.merge(intervals));
        assertArrayEquals(expected, mergeTest(intervals));

        intervals =
            new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18} };
        expected =
            new int[][] {{1, 6}, {8, 10}, {15, 18} };
        assertArrayEquals(expected, solution3.merge(intervals));
        assertArrayEquals(expected, mergeTest(intervals));

        intervals =
            new int[][] {{1, 4}, {4, 5} };
        expected =
            new int[][] {{1, 5} };
        assertArrayEquals(expected, solution3.merge(intervals));
        assertArrayEquals(expected, mergeTest(intervals));

        intervals =
            new int[][] {{4, 7}, {1, 4} };
        expected =
            new int[][] {{1, 7} };
        assertArrayEquals(expected, solution3.merge(intervals));
        assertArrayEquals(expected, mergeTest(intervals));
    }

    public static class Solution1 {
        public int[][] merge(int[][] intervals) {
            List<int[]> list = new ArrayList<>();
            Arrays.sort(
                intervals,
                (a, b) ->
                    a[0] != b[0]
                        ? Integer.compare(a[0], b[0])
                        : Integer.compare(
                        b[1], a[1])); // to avoid integer subtraction overflow
            for (int i = 0; i < intervals.length; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
                    end = Math.max(intervals[i + 1][1], end);
                    i++;
                }
                list.add(new int[] {start, end});
            }
            return list.toArray(new int[list.size()][2]);
        }
    }

    public static class Solution2 {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int st = intervals[0][0], ed = intervals[0][1];
            List<int[]> ans = new ArrayList<>();
            for (int i = 1; i < intervals.length; ++i) {
                int s = intervals[i][0], e = intervals[i][1];
                if (ed < s) {
                    ans.add(new int[] {st, ed});
                    st = s;
                    ed = e;
                } else {
                    ed = Math.max(ed, e);
                }
            }
            ans.add(new int[] {st, ed});
            return ans.toArray(new int[ans.size()][]);
        }
    }

    public static class Solution3 {
        public int[][] merge(int[][] intervals) {
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
}
