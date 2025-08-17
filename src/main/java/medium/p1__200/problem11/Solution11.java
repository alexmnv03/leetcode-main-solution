package medium.p1__200.problem11;

import static org.junit.Assert.assertEquals;


public class Solution11 {

    private static int[] height;
    private static int expected;

    public static int maxAreaTest(int[] height) {
        Solution11.Solution2 solution2 = new Solution11.Solution2();
        return solution2.maxArea(height);
    }

    public static void main(String[] args) {
        Solution11.Solution2 solution2 = new Solution11.Solution2();
        height = new int[] {1, 1};
        expected = 1;
        assertEquals(expected, solution2.maxArea(height));

        height = new int[] {1,8,6,2,5,4,8,3,7};
        expected = 49;
        assertEquals(expected, solution2.maxArea(height));
    }


    public static class Solution1 {
        /*
         * Time: O(n^2)
         * This brute force solution is NOT accepted on LeetCode due to TLE.
         * result = Time Limit Exceeded
         */
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int left = 0; left < height.length - 1; left++) {
                for (int right = height.length - 1; left < right; right--) {
                    int area = (right - left) * Math.min(height[left], height[right]);
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }
    }

    public static class Solution2 {
        /*
         * Two pointer technique.
         * Well explained here: https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
         * 76%
         */
        public int maxArea(int[] height) {
            int max = 0;
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
                if (height[left] <= height[right]) {
                    /*if this height is shorter, then we'll need to move it to the right to find a higher one so that it's possible to find a larger area.*/
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }
}

