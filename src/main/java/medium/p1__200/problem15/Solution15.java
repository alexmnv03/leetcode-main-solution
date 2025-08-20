package medium.p1__200.problem15;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    private static int[] nums;
    private static List<List<Integer>> expected;

    public static List<List<Integer>> threeSumTest(int[] nums) {
        return threeSum(nums);
    }

    public static void main(String[] args) {
        nums = new int[] {1, 2, -2, -1};
        expected = new ArrayList<>();
        assertEquals(expected, threeSum(nums));
        assertEquals(expected, threeSumTest(nums));

        nums = new int[] {-1, 0, 1, 2, -1, -4};
        expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        assertEquals(expected, threeSum(nums));
        assertEquals(expected, threeSumTest(nums));
    }


    /** 56%
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int left = 0; left < nums.length - 2; left++) {
            if (left >= 1 && nums[left] == nums[left - 1]) {
                continue;
            }
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));

                    while (mid < right && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }

                    while (mid < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // these two lines are critical and easy to forget, if so, it'll TLE
                    mid++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return result;
    }
}
