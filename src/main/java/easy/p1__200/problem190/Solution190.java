package easy.p1__200.problem190;

import static org.junit.Assert.assertEquals;

public class Solution190 {

    public static int reverseBitsTest(int n) {
        return reverseBits(n);
    }

    public static void main(String[] args) {

        assertEquals(964176192, reverseBits(43261596));

        assertEquals(964176192, reverseBitsTest(43261596));
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1; // get the most right bit each time
            n >>>= 1; // do UN-signed right shift by 1 each time
            // n >>= 1;//this line works as well on LeetCode OJ, choosing either one works
            if (i < 31) {
                res <<= 1; // shift this number to the left by 1 each time, so that eventually,
                // this number is reversed
            }
        }
        return res;
    }
}
