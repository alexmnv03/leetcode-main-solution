package medium.p1__200.problem31;

import static org.junit.Assert.assertArrayEquals;

public class Solution31 {

    private static int[] nums;

    public static void nextPermutationTest(int[] nums) {
        Solution31.Solution2 solution2 = new Solution31.Solution2();
        solution2.nextPermutation(nums);
    }

    public static void main(String[] args) {
        Solution31.Solution2 solution2 = new Solution31.Solution2();

        nums = new int[] {1, 2, 3};
        solution2.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 3, 2}, nums);
        nums = new int[] {1, 2, 3};
        nextPermutationTest(nums);
        assertArrayEquals(new int[] {1, 3, 2}, nums);

        nums = new int[] {1, 2, 4, 6, 3};
        solution2.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 2, 6, 3, 4}, nums);
        nums = new int[] {1, 2, 4, 6, 3};
        nextPermutationTest(nums);
        assertArrayEquals(new int[] {1, 2, 6, 3, 4}, nums);


        nums = new int[] {1, 2, 4, 6, 3, 2, 1};
        solution2.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 2, 6, 1, 2, 3, 4}, nums);
        nums = new int[] {1, 2, 4, 6, 3, 2, 1};
        nextPermutationTest(nums);
        assertArrayEquals(new int[] {1, 2, 6, 1, 2, 3, 4}, nums);

        nums = new int[] {1, 2, 5, 4, 3};
        solution2.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 3, 2, 4, 5}, nums);
        nums = new int[] {1, 2, 5, 4, 3};
        nextPermutationTest(nums);
        assertArrayEquals(new int[] {1, 3, 2, 4, 5}, nums);

        nums = new int[] {3, 2, 1};
        solution2.nextPermutation(nums);
        assertArrayEquals(new int[] {1, 2, 3}, nums);
        nums = new int[] {3, 2, 1};
        nextPermutationTest(nums);
        assertArrayEquals(new int[] {1, 2, 3}, nums);
    }

    public static class Solution1 {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }

                swap(nums, i, j);
            }

            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int end = nums.length - 1;
            while (start <= end) {
                swap(nums, start++, end--);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static class Solution2 {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;
            for (; i >= 0; --i) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }
            if (i >= 0) {
                for (int j = n - 1; j > i; --j) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }

            for (int j = i + 1, k = n - 1; j < k; ++j, --k) {
                swap(nums, j, k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
    }
}
