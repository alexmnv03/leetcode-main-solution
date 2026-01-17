package medium.p1__200.problem53;


import static org.junit.Assert.assertEquals;

public class Solution53 {

    private static int[] numsArray;

    public static int maxSubArrayTest(int[] nums) {
        Solution53.Solution1 solution1 = new Solution53.Solution1();
        return solution1.maxSubArray(nums);
    }

    public static void main(String[] args) {
        Solution53.Solution1 solution1 = new Solution53.Solution1();
        numsArray = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, solution1.maxSubArray(numsArray));
        assertEquals(6, maxSubArrayTest(numsArray));

        solution1 = new Solution53.Solution1();
        numsArray = new int[] {1};
        assertEquals(1, solution1.maxSubArray(numsArray));
        assertEquals(1, maxSubArrayTest(numsArray));

        solution1 = new Solution53.Solution1();
        numsArray = new int[] {5,4,-1,7,8};
        assertEquals(23, solution1.maxSubArray(numsArray));
        assertEquals(23, maxSubArrayTest(numsArray));
    }


    public static class Solution1 {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            for (int i = 1, f = nums[0]; i < nums.length; ++i) {
                f = Math.max(f, 0) + nums[i];
                ans = Math.max(ans, f);
            }
            return ans;
        }
    }

    public static class Solution2 {
        public int maxSubArray(int[] nums) {
            return maxSub(nums, 0, nums.length - 1);
        }

        private int maxSub(int[] nums, int left, int right) {
            if (left == right) {
                return nums[left];
            }
            int mid = (left + right) >>> 1;
            int lsum = maxSub(nums, left, mid);
            int rsum = maxSub(nums, mid + 1, right);
            return Math.max(Math.max(lsum, rsum), crossMaxSub(nums, left, mid, right));
        }

        private int crossMaxSub(int[] nums, int left, int mid, int right) {
            int lsum = 0, rsum = 0;
            int lmx = Integer.MIN_VALUE, rmx = Integer.MIN_VALUE;
            for (int i = mid; i >= left; --i) {
                lsum += nums[i];
                lmx = Math.max(lmx, lsum);
            }
            for (int i = mid + 1; i <= right; ++i) {
                rsum += nums[i];
                rmx = Math.max(rmx, rsum);
            }
            return lmx + rmx;
        }
    }

    public static class Solution3 {
        public int maxSubArray(int[] nums) {
            int globalMax = nums[0];
            int currentMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                globalMax = Math.max(currentMax, globalMax);
            }
            return globalMax;
        }
    }
}
