package medium.p1__200.problem18;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution18 {

    private static int target;
    private static int[] nums;
    private static List<List<Integer>> expected;

    public static List<List<Integer>> fourSumTest(int[] nums, int target) {
        Solution18.Solution4 solution2 = new Solution18.Solution4();
        return solution2.fourSum(nums, target);
    }

    public static void main(String[] args) {
        Solution18.Solution4 solution2 = new Solution18.Solution4();

        target = 0;
        nums = new int[] {1,0,-1,0,-2,2};
        expected = new ArrayList<>();
        expected.add(Arrays.asList(-2,-1,1,2));
        expected.add(Arrays.asList(-2,0,0,2));
        expected.add(Arrays.asList(-1,0,0,1));
        assertEquals(expected, solution2.fourSum(nums, target));
        assertEquals(fourSumTest(nums, target), solution2.fourSum(nums, target));

        target = 8;
        nums = new int[] {2,2,2,2,2};
        expected = new ArrayList<>();
        expected.add(Arrays.asList(2,2,2,2));
        assertEquals(expected, solution2.fourSum(nums, target));
        assertEquals(fourSumTest(nums, target), solution2.fourSum(nums, target));
    }

    public static class Solution4 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            if (n < 4) {
                return ans;
            }
            Arrays.sort(nums);
            for (int i = 0; i < n - 3; ++i) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < n - 2; ++j) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int k = j + 1, l = n - 1;
                    while (k < l) {
                        long x = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (x < target) {
                            ++k;
                        } else if (x > target) {
                            --l;
                        } else {
                            ans.add(List.of(nums[i], nums[j], nums[k++], nums[l--]));
                            while (k < l && nums[k] == nums[k - 1]) {
                                ++k;
                            }
                            while (k < l && nums[l] == nums[l + 1]) {
                                --l;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    //Time Limit Exceeded
    public static class Solution1 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList();
            if (nums == null || nums.length == 0) {
                return result;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j - 1] == nums[j]) {
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left + 1 < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (right - 1 > left && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            left++;
                            right--;
                        } else if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
            return result;
        }
    }

    //Time Limit Exceeded
    public static class Solution2 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    for (int k = j + 1; k < nums.length - 1; k++) {
                        for (int p = k + 1; p < nums.length; p++) {
                            int sum = nums[i] + nums[j] + nums[k] + nums[p];
                            if (sum == target) {
                                set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[p]));
                            }
                        }
                    }
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            for (List<Integer> each : set) {
                result.add(each);
            }
            return result;
        }
    }

    //Time Limit Exceeded
    public static class Solution3 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int len = nums.length;
            if (len < 4) return Collections.emptyList();
            int max = nums[len - 1];
            if (4 * max < target) return Collections.emptyList();
            return kSum(nums, 0, 4, target);
        }

        private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (k == 2) {
                int left = start, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> twoSum = new LinkedList<>();
                        twoSum.add(nums[left]);
                        twoSum.add(nums[right]);
                        res.add(twoSum);
                        while (nums[left] == nums[++left] && left < right) ;
                        while (nums[right] == nums[--right] && left < right) ;
                    } else if (sum < target) ++left;
                    else --right;
                }
            } else {
                int i = start, end = nums.length - (k - 1), max = nums[nums.length - 1];
                while (i < end) {
                    if (nums[i] * k > target) return res;
                    if (nums[i] + (k - 1) * max < target) {
                        while (nums[i] == nums[++i] && i < end) ;
                        continue;
                    }
                    List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                    while (nums[i] == nums[++i] && i < end) ;
                }
            }
            return res;
        }
    }
}
