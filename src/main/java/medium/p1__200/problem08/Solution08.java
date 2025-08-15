package medium.p1__200.problem08;

import static org.junit.Assert.assertEquals;

public class Solution08 {

    public static int myAtoiTest(String s) {
        return myAtoi(s);
    }

    public static void main(String[] args) {
        String s = "42";
        assertEquals(myAtoiTest(s), myAtoi(s));
        s = " -042";
        assertEquals(myAtoiTest(s), myAtoi(s));
        s = "1337c0d3";
        assertEquals(myAtoiTest(s), myAtoi(s));
        s = "0-1";
        assertEquals(myAtoiTest(s), myAtoi(s));
        s = "words and 987";
        assertEquals(myAtoiTest(s), myAtoi(s));
    }

    /*
     * four corner cases:
     * 1. discards all leading zeroes
     * 2. sign of the number
     * 3. overflow
     * 4. invalid input
     */
    public static int myAtoi(String s) {
        int pointer = 0;
        int result = 0;
        while (pointer < s.length() && Character.isWhitespace(s.charAt(pointer))) {
            pointer++;
        }
        if (pointer == s.length()) {
            return 0;
        }
        boolean negativeFlag = (s.charAt(pointer) == '-');
        if (s.charAt(pointer) == '+' || s.charAt(pointer) == '-') {
            pointer++;
        }
        for (; pointer < s.length(); pointer++) {
            if (s.charAt(pointer) > '9' || s.charAt(pointer) < '0') {
                break;
            } else {
                int digit = s.charAt(pointer) - '0';
                if (!negativeFlag && result > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                } else if (negativeFlag && result < (Integer.MIN_VALUE + digit) / 10) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + (negativeFlag ? -digit : digit);
            }
        }
        return result;
    }
}
