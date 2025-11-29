package medium.p1__200.problem45;

import static org.junit.Assert.assertEquals;


public class Solution45 {

    private static int[] nums;

    public static int jumpTest(int[] nums) {
        Solution45.Solution2 solution2 = new Solution45.Solution2();
        return solution2.jump(nums);
    }

    public static void main(String[] args) {
        Solution45.Solution2 solution2 = new Solution45.Solution2();

        nums = new int[] {2, 3, 1, 1, 4};
        assertEquals(2, solution2.jump(nums));
        assertEquals(2, jumpTest(nums));

        nums = new int[] {2,3,0,1,4};
        assertEquals(2, solution2.jump(nums));
        assertEquals(2, jumpTest(nums));
    }

    public static class Solution1 {
        public int jump(int[] nums) {
            int jumps = 0;
            int lastJumpMax = 0;
            int currentJumpMax = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                currentJumpMax = Math.max(currentJumpMax, i + nums[i]);
                if (i == lastJumpMax) {
                    jumps++;
                    lastJumpMax = currentJumpMax;
                }
                if (lastJumpMax >= nums.length) {
                    return jumps;
                }
            }
            return jumps;
        }
    }

    public static class Solution2 {
        public int jump(int[] nums) {
            int ans = 0, mx = 0, last = 0;
            for (int i = 0; i < nums.length - 1; ++i) {
                mx = Math.max(mx, i + nums[i]);
                if (last == i) {
                    ++ans;
                    last = mx;
                }
            }
            return ans;
        }
    }
}
