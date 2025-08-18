package medium.p1__200.problem12;

import static org.junit.Assert.assertEquals;

public class Solution12 {

    public static String intToRomanTest(int num) {
        return intToRoman(num);
    }

    public static void main(String[] args) {
        int num = 3749;
        assertEquals(intToRomanTest(num), intToRoman(num));

        num = 58;
        assertEquals(intToRomanTest(num), intToRoman(num));

        num = 1994;
        assertEquals(intToRomanTest(num), intToRoman(num));
    }


    // 5%
    public static String intToRoman(int num) {
        String[] M = new String[] {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
