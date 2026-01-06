package medium.p1__200.problem50;


import static org.junit.Assert.assertEquals;

public class Solution50 {

    public static double myPowTest(double x, int n) {
        Solution50.Solution4 solution4 = new Solution50.Solution4();
        return solution4.myPow(x, n);
    }

    public static void main(String[] args) {
        Solution50.Solution4 solution4 = new Solution50.Solution4();

        assertEquals(1024.00000, solution4.myPow(2.00000, 10), 0.00001);
        assertEquals(9.26100, solution4.myPow(2.10000, 3), 0.00001);
        assertEquals(0.25000, solution4.myPow(2.00000, -2), 0.00001);

        assertEquals(1024.00000, myPowTest(2.00000, 10), 0.00001);
        assertEquals(9.26100, myPowTest(2.10000, 3), 0.00001);
        assertEquals(0.25000, myPowTest(2.00000, -2), 0.00001);
    }

    public static class Solution1 {
        /*
         * Time: O(logn)
         * Space: O(logn)
         */
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            return fastPow(x, N);
        }

        private double fastPow(double x, long n) {
            if (n == 0) {
                return 1.0;
            }
            double half = fastPow(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        }
    }

    public static class Solution2 {
        /*
         * Time: O(logn)
         * Space: O(1)
         */
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double answer = 1;
            double currentProduct = x;
            for (long i = N; i > 0; i /= 2) {
                if (i % 2 == 1) {
                    answer = answer * currentProduct;
                }
                currentProduct *= currentProduct;
            }
            return answer;
        }
    }

    public static class Solution3 {
        /*
         * credit: https://leetcode.com/problems/powx-n/solutions/19546/short-and-easy-to-understand-solution/comments/162293
         */
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                // this is to avoid integer overflow
                return 1 / x * myPow(1 / x, -(n + 1));
            }
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return x * myPow(x * x, n / 2);
            }
        }
    }

    public static class Solution4 {
        public double myPow(double x, int n) {
            return n >= 0 ? qpow(x, n) : 1 / qpow(x, -(long) n);
        }

        private double qpow(double a, long n) {
            double ans = 1;
            for (; n > 0; n >>= 1) {
                if ((n & 1) == 1) {
                    ans = ans * a;
                }
                a = a * a;
            }
            return ans;
        }
    }
}
