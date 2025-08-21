package medium.p1__200.problem16;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class Solution16 {

    private static int[] nums;

    public static int threeSumClosestTest(int[] nums, int target) {
        return threeSumClosest(nums, target);
    }

    public static void main(String[] args) {
        nums = new int[] {-1,2,1,-4};
        assertEquals(2, threeSumClosest(nums, 1));
        assertEquals(2, threeSumClosestTest(nums, 1));

        nums = new int[] {0,0,0};
        assertEquals(0, threeSumClosest(nums, 1));
        assertEquals(0, threeSumClosestTest(nums, 1));

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int thisSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(thisSum - target) < Math.abs(sum - target)) {
                    sum = thisSum;
                    if (sum == target) {
                        return sum;
                    }
                } else if (target > thisSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }
}
