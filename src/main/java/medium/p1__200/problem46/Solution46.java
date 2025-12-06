package medium.p1__200.problem46;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import common.CommonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution46 {

    static List<List<Integer>> expectedOne = Arrays.asList(
        Arrays.asList(1)
    );

    static List<List<Integer>> expectedTwo = Arrays.asList(
        Arrays.asList(0, 1),
        Arrays.asList(1, 0)
    );

    static List<List<Integer>> expectedThree = Arrays.asList(
        Arrays.asList(1,2,3),
        Arrays.asList(1,3,2),
        Arrays.asList(2,1,3),
        Arrays.asList(2,3,1),
        Arrays.asList(3,1,2),
        Arrays.asList(3,2,1)
    );

    public static List<List<Integer>> permuteTest(int[] nums) {
        Solution46.Solution4 solution4 = new Solution46.Solution4();
        return solution4.permute(nums);
    }

    public static void main(String[] args) {
        Solution46.Solution4 solution4 = new Solution46.Solution4();

        System.out.println("1 = ");
        CommonUtils.printListList(solution4.permute(new int[] {1}));
        System.out.println("2 = ");
        CommonUtils.printListList(solution4.permute(new int[] {0, 1}));
        System.out.println("3 = ");
        CommonUtils.printListList(solution4.permute(new int[] {1, 2, 3}));
        //CommonUtils.printListList(solution4.permute(new int[] {1, 2, 3, 4, 5, 6}));

        Solution46.Solution4 solution41 = new Solution46.Solution4();
        assertEquals(expectedOne, solution41.permute(new int[] {1}));
        assertEquals(expectedOne, permuteTest(new int[] {1}));

        Solution46.Solution4 solution42 = new Solution46.Solution4();
        assertEquals(expectedTwo, solution42.permute(new int[] {0, 1}));
        assertEquals(expectedTwo, permuteTest(new int[] {0, 1}));

        Solution46.Solution4 solution43 = new Solution46.Solution4();
        assertEquals(expectedThree, solution43.permute(new int[] {1, 2, 3}));
        assertEquals(expectedThree, permuteTest(new int[] {1, 2, 3}));
    }

    public static class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            result.add(new ArrayList<>());
            return recurse(nums, 0, result);
        }

        private List<List<Integer>> recurse(int[] nums, int index, List<List<Integer>> result) {
            if (index == nums.length) {
                return result;
            }
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> list : result) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i, nums[index]);
                    newResult.add(newList);
                }
            }
            return recurse(nums, index + 1, newResult);
        }
    }

    public static class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            Set<List<Integer>> ans = new HashSet<>();
            boolean[] used = new boolean[nums.length];
            backtracking(new ArrayList<>(), nums, ans, used);
            List<List<Integer>> result = new ArrayList<>();
            for (List<Integer> list : ans) {
                result.add(list);
            }
            return result;
        }

        private void backtracking(
            List<Integer> list, int[] nums, Set<List<Integer>> ans, boolean[] used) {
            if (list.size() == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i <= list.size(); i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (!used[j]) {
                        used[j] = true;
                        list.add(i, nums[j]);
                        backtracking(list, nums, ans, used);
                        used[j] = false;
                        list.remove(i);
                    }
                }
            }
        }
    }

    public static class Solution3 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            return backtracking(ans, used, new ArrayList<>(), nums);
        }

        private List<List<Integer>> backtracking(
            List<List<Integer>> ans, boolean[] used, List<Integer> list, int[] nums) {
            if (list.size() == nums.length) {
                ans.add(new ArrayList<>(list));
                return ans;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                list.add(nums[i]);
                backtracking(ans, used, list, nums);
                used[i] = false;
                list.remove(list.size() - 1);
            }
            return ans;
        }
    }

    public static class Solution4 {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> t = new ArrayList<>();
        private boolean[] vis;
        private int[] nums;

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            vis = new boolean[nums.length];
            dfs(0);
            return ans;
        }

        private void dfs(int i) {
            if (i == nums.length) {
                ans.add(new ArrayList<>(t));
                return;
            }
            for (int j = 0; j < nums.length; ++j) {
                if (!vis[j]) {
                    vis[j] = true;
                    t.add(nums[j]);
                    dfs(i + 1);
                    t.remove(t.size() - 1);
                    vis[j] = false;
                }
            }
        }
    }
}
