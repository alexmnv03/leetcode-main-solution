package medium.p1__200.problem47;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution47 {

    static List<List<Integer>> expectedOne = Arrays.asList(
        Arrays.asList(1, 1, 2),
        Arrays.asList(1, 2, 1),
        Arrays.asList(2, 1, 1)
    );

    static List<List<Integer>> expectedTwo = Arrays.asList(
        Arrays.asList(1, 2, 3),
        Arrays.asList(1, 3, 2),
        Arrays.asList(2, 1, 3),
        Arrays.asList(2, 3, 1),
        Arrays.asList(3, 1, 2),
        Arrays.asList(3, 2, 1)
    );


    public static List<List<Integer>> permuteUniqueTest(int[] nums) {
        Solution47.Solution3 solution3 = new Solution47.Solution3();
        return solution3.permuteUnique(nums);
    }

    public static void main(String[] args) {
        Solution47.Solution3 solution3 = new Solution47.Solution3();

        assertEquals(expectedOne, solution3.permuteUnique(new int[] {1, 1, 2}));
        assertEquals(expectedOne, permuteUniqueTest(new int[] {1, 1, 2}));

        Solution47.Solution3 solution31 = new Solution47.Solution3();
        assertEquals(expectedTwo, solution31.permuteUnique(new int[] {1, 2, 3}));
        assertEquals(expectedTwo, permuteUniqueTest(new int[] {1, 2, 3}));
    }

    public static class Solution1 {
        /*
         * credit: https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote
         */
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            if (nums == null || nums.length == 0) {
                return result;
            }
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums); // this sorting is critical for the correctness of this backtracking
            // algorithm as we compare the two adjacent neighbors to filter out
            // possible duplicate permutations
            backtracking(nums, used, new ArrayList(), result);
            return result;
        }

        private void backtracking(
            int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
            if (list.size() == nums.length) {
                result.add(new ArrayList(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i] && used[i - 1]) {
                    /*
                     * For this line, both !used[i-1] and used[i-1] will AC.
                     * It is because the first one makes sure when duplicates are selected, the order is ascending (index from small to large).
                     * However, the second one means the descending order.
                     * But without this used[i - 1] or !used[i - 1] will not yield a correct result as the program will not yield a correct result.
                     */
                    continue;
                }
                used[i] = true;
                list.add(nums[i]);
                backtracking(nums, used, list, result);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static class Solution2 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> set = new HashSet<>();
            set.add(new ArrayList<>());
            set = recurse(nums, set, 0);
            List<List<Integer>> res = new ArrayList<>();
            for (List<Integer> list : set) {
                res.add(list);
            }
            return res;
        }

        private Set<List<Integer>> recurse(int[] nums, Set<List<Integer>> set, int pos) {
            if (pos == nums.length) {
                return set;
            }
            Set<List<Integer>> newSet = new HashSet<>();
            for (List<Integer> list : set) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i, nums[pos]);
                    newSet.add(newList);
                }
            }
            return recurse(nums, newSet, pos + 1);
        }
    }

    public static class Solution3 {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> t = new ArrayList<>();
        private int[] nums;
        private boolean[] vis;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
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
                if (vis[j] || (j > 0 && nums[j] == nums[j - 1] && !vis[j - 1])) {
                    continue;
                }
                t.add(nums[j]);
                vis[j] = true;
                dfs(i + 1);
                vis[j] = false;
                t.remove(t.size() - 1);
            }
        }
    }
}
