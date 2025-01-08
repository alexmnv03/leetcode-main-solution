package easy.p1__200.problem067;

import static org.junit.Assert.assertEquals;

public class Solution67 {

    public static String addBinaryTest(String a, String b) {
        return addBinary(a, b);

    }

    public static String addBinaryShortTest(String a, String b) {
        return addBinaryShort(a, b);
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        assertEquals("100", addBinary("11", "1"));
        assertEquals("100", addBinaryShort("11", "1"));
        assertEquals("100", addBinaryTest("11", "1"));
        assertEquals("100", addBinaryShortTest("11", "1"));

        System.out.println(addBinary("1010", "1011"));
        assertEquals("10101", addBinary("1010", "1011"));
        assertEquals("10101", addBinaryShort("1010", "1011"));
        assertEquals("10101", addBinaryTest("1010", "1011"));
        assertEquals("10101", addBinaryShortTest("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += a.charAt(p1--) - '0';
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p1 >= 0) {
            carry += a.charAt(p1--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static String addBinaryShort(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        return sb.toString();
    }

}
