package easy.p1__200.problem191;

import static org.junit.Assert.assertEquals;

public class Solution191 {

    public static int hammingWeightTest(int n) {
        return hammingWeight(n);
    }

    public static void main(String[] args) {
        assertEquals(1, hammingWeight(1));
        assertEquals(1, hammingWeight(2));
        assertEquals(30, hammingWeight(2147483645));

        assertEquals(1, hammingWeightTest(1));
        assertEquals(1, hammingWeightTest(2));
        assertEquals(30, hammingWeightTest(2147483645));
    }

    public static int hammingWeight(int n) {
        int bits = 0;
        while (n != 0) {
            bits++;
            n &= (n - 1);
        }
        return bits;
    }

    public static class Solution2 {
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }

    public static class Solution3 {
        public int hammingWeight(int n) {
            int bits = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & 1) == 1) {
                    bits++;
                }
                if (n == 0) {
                    return bits;
                }
                /*must use unsigned right shift operator since the problem says this is an unsigned value*/
                n >>>= 1;
            }
            return bits;
        }
    }

    public static class Solution4 {
        public int hammingWeight(int n) {
            int bits = 0;
            for (int i = 0; i < 32; i++) {
                bits += n & 1;
                n >>>= 1;
            }
            return bits;
        }
    }
}
