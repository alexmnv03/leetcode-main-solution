package easy.p1__200.problem118;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution118 {

    public static List<List<Integer>> generateTest(int numRows) {
        return generate(numRows);
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(1));
        List<List<Integer>> list5 = List.of(
            List.of(1),
            List.of(1, 1),
            List.of(1, 2, 1),
            List.of(1, 3, 3, 1),
            List.of(1, 4, 6, 4, 1)
        );

        List<List<Integer>> list1 = List.of(
            List.of(1)
        );

        assertEquals(list5 , generate(5));
        assertEquals(list1 , generate(1));

        assertEquals(list5 , generateTest(5));
        assertEquals(list1 , generateTest(1));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                    List<Integer> upSub = list.get(i - 1);
                    sub.add(upSub.get(j - 1) + upSub.get(j));
                }
            }
            list.add(sub);
        }
        return list;
    }


    public static class Solution1 {
        /*
         * fill out values from left to right
         */
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList();
            List<Integer> row = new ArrayList();
            for (int i = 0; i < numRows; i++) {
                row.add(0, 1);
                for (int j = 1; j < row.size() - 1; j++) {
                    row.set(j, row.get(j) + row.get(j + 1));
                }
                result.add(new ArrayList(row));
            }
            return result;
        }
    }

    public static class Solution2 {
        /*
         * fill out values from right to left
         * credit: https://leetcode.com/problems/pascals-triangle/discuss/38141/My-concise-solution-in-Java/36127
         */
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList();
            List<Integer> row = new ArrayList();
            for (int i = 0; i < numRows; i++) {
                for (int j = row.size() - 1; j >= 1; j--) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
                row.add(1);
                result.add(new ArrayList<>(row));
            }
            return result;
        }
    }

    public static class Solution3 {
        /*
         * my completely original solution on 9/15/2021
         */
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                if (ans.isEmpty()) {
                    ans.add(Arrays.asList(1));
                } else {
                    List<Integer> prev = ans.get(ans.size() - 1);
                    List<Integer> curr = new ArrayList<>(prev.size() + 1);
                    curr.add(1);
                    for (int j = 0; j < prev.size() - 1; j++) {
                        curr.add(prev.get(j) + prev.get(j + 1));
                    }
                    curr.add(1);
                    ans.add(curr);
                }
            }
            return ans;
        }
    }

}
