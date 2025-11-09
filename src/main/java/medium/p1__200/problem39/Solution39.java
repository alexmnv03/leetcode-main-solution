package medium.p1__200.problem39;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {

    private static int[] candidates;
    private static List<List<Integer>> expected;


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Solution39.Solution2 solution2 = new Solution39.Solution2();
        return solution2.combinationSum(candidates, target);
    }

    public static void main(String[] args) {
        Solution39.Solution2 solution2 = new Solution39.Solution2();
        candidates = new int[] {2, 3, 6, 7};
        expected = new ArrayList<>();
        expected.add(Arrays.asList(2, 2, 3));
        expected.add(Arrays.asList(7));
        assertEquals(expected, solution2.combinationSum(candidates, 7));
        assertEquals(expected, combinationSum(candidates, 7));

        solution2 = new Solution39.Solution2();
        candidates = new int[] {2,3,5};
        expected = new ArrayList<>();
        expected.add(Arrays.asList(2,2,2,2));
        expected.add(Arrays.asList(2,3,3));
        expected.add(Arrays.asList(3,5));
        assertEquals(expected, solution2.combinationSum(candidates, 8));
        assertEquals(expected, combinationSum(candidates, 8));

        solution2 = new Solution39.Solution2();
        candidates = new int[] {2};
        expected = new ArrayList<>();
        assertEquals(expected, solution2.combinationSum(candidates, 1));
        assertEquals(expected, combinationSum(candidates, 1));
    }

    public static class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList();
            Arrays.sort(candidates);
            backtracking(candidates, target, 0, new ArrayList(), result);
            return result;
        }

        void backtracking(
            int[] candidates,
            int target,
            int start,
            List<Integer> curr,
            List<List<Integer>> result) {
            if (target > 0) {
                for (int i = start; i < candidates.length; i++) {
                    if (candidates[i] > target) {
                        break; // pruning
                    }
                    curr.add(candidates[i]);
                    backtracking(candidates, target - candidates[i], i, curr, result);
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

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            dfs(0, target);
            return ans;
        }

        private void dfs(int i, int s) {
            if (s == 0) {
                ans.add(new ArrayList(t));
                return;
            }
            if (s < candidates[i]) {
                return;
            }
            for (int j = i; j < candidates.length; ++j) {
                t.add(candidates[j]);
                dfs(j, s - candidates[j]);
                t.remove(t.size() - 1);
            }
        }
    }

    public static class Solution3 {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> t = new ArrayList<>();
        private int[] candidates;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            dfs(0, target);
            return ans;
        }

        private void dfs(int i, int s) {
            if (s == 0) {
                ans.add(new ArrayList(t));
                return;
            }
            if (i >= candidates.length || s < candidates[i]) {
                return;
            }
            dfs(i + 1, s);
            t.add(candidates[i]);
            dfs(i, s - candidates[i]);
            t.remove(t.size() - 1);
        }
    }
}
