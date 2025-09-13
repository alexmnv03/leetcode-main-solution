package medium.p1__200.problem29;

import static org.junit.Assert.assertEquals;


public class Solution29 {

    public static int divideTest(int a, int b) {
        Solution29.Solution3 solution3 = new Solution29.Solution3();
        return solution3.divide(a, b);
    }

    public static void main(String[] args) {
        Solution29.Solution3 solution3 = new Solution29.Solution3();

        assertEquals(3, solution3.divide(10, 3));
        assertEquals(-2, solution3.divide(7, -3));

        assertEquals(3, divideTest(10, 3));
        assertEquals(-2, divideTest(7, -3));
    }

    public static class Solution1 {
        /*
         * credit: https://leetcode.com/problems/divide-two-integers/solution/ solution 1
         * TimeLimited
         * <p>
         * Key notes:
         * 1. dividend = Integer.MAX_VALUE and divisor = -1 is a special case which will be handled separately;
         * 2. because within the given range, [-2_31 to 2_31 - 1], every positive integer could be mapped to a corresponding negative integer while the opposite is not true
         * because of the smallest number: Integer.MIN_VALUE = -2147483648 doesn't have one (Integer.MAX_VALUE is 2147483647). So we'll turn both dividend and divisor into negative numbers to do the operation;
         * 3. division, in its essence, is subtraction multiple times until it cannot be subtracted any more
         * <p>
         * Time: O(n)
         * Space: O(1)
         */
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int negativeCount = 0;
            if (dividend < 0) {
                negativeCount++;
            } else {
                dividend = -dividend;
            }
            if (divisor < 0) {
                negativeCount++;
            } else {
                divisor = -divisor;
            }

            int quotient = 0;
            while (dividend <= divisor) {
                dividend -= divisor;
                quotient++;
            }
            if (negativeCount == 1) {
                quotient = -quotient;
            }
            return quotient;
        }
    }

    public static class Solution2 {
        /*
         * credit: https://leetcode.com/problems/divide-two-integers/solution/ solution 2
         * <p>
         * 1. exponetial growth to check to speed up
         * 2. we still turn all numbers into negatives because negatives are a superset of all numbers in the positives.
         * <p>
         * Time: O(log2n)
         * Space: O(1)
         */
        private static final int HALF_INT_MIN = Integer.MIN_VALUE / 2;

        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int negativeCount = 0;
            if (dividend < 0) {
                negativeCount++;
            } else {
                dividend = -dividend;
            }
            if (divisor < 0) {
                negativeCount++;
            } else {
                divisor = -divisor;
            }
            int quotient = 0;
            while (dividend <= divisor) {
                int powerOfTwo = -1;
                int value = divisor;
                while (value >= HALF_INT_MIN && value + value >= dividend) {
                    value += value;
                    powerOfTwo += powerOfTwo;
                }
                quotient += powerOfTwo;
                dividend -= value;
            }
            if (negativeCount != 1) {
                quotient = -quotient;
            }
            return quotient;
        }
    }

    public static class Solution3 {
        public int divide(int dividend, int divisor) {
            if (divisor == 1) {
                return dividend;
            }
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
            dividend = dividend > 0 ? -dividend : dividend;
            divisor = divisor > 0 ? -divisor : divisor;
            int ans = 0;
            while (dividend <= divisor) {
                int x = divisor;
                int cnt = 1;
                while (x >= (Integer.MIN_VALUE >> 1) && dividend <= (x << 1)) {
                    x <<= 1;
                    cnt <<= 1;
                }
                ans += cnt;
                dividend -= x;
            }
            return sign ? ans : -ans;
        }
    }
}
