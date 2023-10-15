package easy.p1401__1600.problem1480;

public class Solution1480 {

    public int[] runningSum(int[] nums) {
        int[] out = new int[nums.length];
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            out[i] = sum;
        }
        return out;
    }

}
