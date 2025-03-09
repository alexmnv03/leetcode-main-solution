package easy.p1__200.problem171;

import static org.junit.Assert.assertEquals;

public class Solution171 {

    public static int titleToNumberTest(String s) {
        return titleToNumber(s);
    }

    public static void main(String[] args) {
        assertEquals(1, titleToNumber("A"));
        assertEquals(28, titleToNumber("AB"));
        assertEquals(701, titleToNumber("ZY"));

        assertEquals(1, titleToNumberTest("A"));
        assertEquals(28, titleToNumberTest("AB"));
        assertEquals(701, titleToNumberTest("ZY"));
    }

    public static int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result +=
                (c[i] - 64)
                    * ((int)
                    Math.pow(
                        26,
                        s.length() - i - 1)); // The ASCII value of A is 65
        }
        return result;
    }
}
