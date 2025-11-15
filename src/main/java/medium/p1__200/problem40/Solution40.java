package medium.p1__200.problem40;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {

    private static int[] candidates;
    private static int target;
    private static List<List<Integer>> expected;

    public static List<List<Integer>> combinationSum2Test(int[] candidates, int target) {
        Solution40.Solution2 solution2 = new Solution40.Solution2();
        return solution2.combinationSum2(candidates, target);
    }

    public static void main(String[] args) {
        Solution40.Solution2 solution2 = new Solution40.Solution2();
        candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
        expected =
            Arrays.asList(
                (Arrays.asList(1, 1, 6)),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 7),
                Arrays.asList(2, 6));
        target = 8;
        assertEquals(expected, solution2.combinationSum2(candidates, target));
        assertEquals(expected, combinationSum2Test(candidates, target));

        solution2 = new Solution40.Solution2();
        candidates = new int[] {2,5,2,1,2};
        expected =
            Arrays.asList(
                (Arrays.asList(1, 2, 2)),
                Arrays.asList(5));
        target = 5;
        assertEquals(expected, solution2.combinationSum2(candidates, target));
        assertEquals(expected, combinationSum2Test(candidates, target));

        solution2 = new Solution40.Solution2();
        candidates =
            new int[] {
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
            };
        expected =
            Arrays.asList(
                Arrays.asList(
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1));
        target = 30;
        assertEquals(expected, solution2.combinationSum2(candidates, target));
        assertEquals(expected, combinationSum2Test(candidates, target));
    }

    //17%
    public static class Solution1 {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList();
            Arrays.sort(candidates);
            backtracking(candidates, 0, result, target, new ArrayList());
            return result;
        }

        void backtracking(
            int[] candidates,
            int start,
            List<List<Integer>> result,
            int target,
            List<Integer> curr) {
            if (target > 0) {
                for (int i = start; i < candidates.length; i++) {
                    if (candidates[i] > target
                        || (i > start && candidates[i - 1] == candidates[i])) {
                        continue;
                    }
                    curr.add(candidates[i]);
                    backtracking(candidates, i + 1, result, target - candidates[i], curr);
                    curr.remove(curr.size() - 1);
                }
            } else if (target == 0) {
                result.add(new ArrayList(curr));
            }
        }
    }

    public static class Solution2 {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> t = new ArrayList<>();
        private int[] candidates;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            dfs(0, target);
            return ans;
        }

        private void dfs(int i, int s) {
            if (s == 0) {
                ans.add(new ArrayList<>(t));
                return;
            }
            if (i >= candidates.length || s < candidates[i]) {
                return;
            }
            for (int j = i; j < candidates.length; ++j) {
                if (j > i && candidates[j] == candidates[j - 1]) {
                    continue;
                }
                t.add(candidates[j]);
                dfs(j + 1, s - candidates[j]);
                t.remove(t.size() - 1);
            }
        }
    }

    public static class Solution3 {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> t = new ArrayList<>();
        private int[] candidates;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            dfs(0, target);
            return ans;
        }

        private void dfs(int i, int s) {
            if (s == 0) {
                ans.add(new ArrayList<>(t));
                return;
            }
            if (i >= candidates.length || s < candidates[i]) {
                return;
            }
            int x = candidates[i];
            t.add(x);
            dfs(i + 1, s - x);
            t.remove(t.size() - 1);
            while (i < candidates.length && candidates[i] == x) {
                ++i;
            }
            dfs(i, s);
        }
    }
}
