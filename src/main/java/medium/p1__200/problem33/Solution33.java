package medium.p1__200.problem33;

import static org.junit.Assert.assertEquals;


public class Solution33 {

    private static int[] nums;
    private static int expected;
    private static int target;

    public static int searchTest(int[] nums, int target) {
        Solution33.Solution2 solution2 = new Solution33.Solution2();
        return solution2.search(nums, target);
    }

    public static void main(String[] args) {
        Solution33.Solution2 solution2 = new Solution33.Solution2();

        nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        expected = 3;
        target = 7;
        assertEquals(expected, solution2.search(nums, target));
        assertEquals(expected, searchTest(nums, target));

        nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        expected = 4;
        target = 0;
        assertEquals(expected, solution2.search(nums, target));
        assertEquals(expected, searchTest(nums, target));

        nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        expected = 1;
        target = 5;
        assertEquals(expected, solution2.search(nums, target));
        assertEquals(expected, searchTest(nums, target));

        nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        expected = -1;
        target = 3;
        assertEquals(expected, solution2.search(nums, target));
        assertEquals(expected, searchTest(nums, target));

        nums = new int[] {1};
        expected = -1;
        target = 0;
        assertEquals(expected, solution2.search(nums, target));
        assertEquals(expected, searchTest(nums, target));
    }

    public static class Solution1 {
        /*
         * Credit: https://leetcode.com/problems/search-in-rotated-sorted-array/editorial/
         * Approach 3 says it very well.
         */
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[left] <= nums[mid]) {
                    // this is for this case: [4, 5, 6, 7, 0, 1, 2], target = 4
                    // this means that the left sub-array is sorted
                    if (target >= nums[left] && target < nums[mid]) {
                        // in this case, if target exists, in must be in this left sorted sub-array
                        right = mid - 1;
                    } else {
                        // otherwise, it's in the other half
                        // e.g. this case: [4, 5, 6, 7, 0, 1, 2], target = 2
                        left = mid + 1;
                    }
                } else {
                    // this is for this case: [8, 9, 2, 3, 4], target = 9
                    // this means the right sub-array is sorted and the left sub-array is rotated at
                    // some pivot
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return nums[left] == target ? left : -1;
        }
    }

    public static class Solution2 {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target <= nums[mid]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return nums[left] == target ? left : -1;
        }
    }
}
