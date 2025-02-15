package easy.p1__200.problem125;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class Solution125 {

    public static boolean isPalindromeTest(String s) {
        return isPalindrome(s);
    }

    public static void main(String[] args) {

        String line1 = "A man, a plan, a canal: Panama";
        String line2 = "race a car";
        String line3 = " ";
        System.out.println(isPalindrome(line1));
        System.out.println(isPalindrome(line2));
        System.out.println(isPalindrome(line3));

        assertTrue(isPalindrome(line1));
        assertFalse(isPalindrome(line2));
        assertTrue(isPalindrome(line3));

        assertTrue(isPalindromeTest(line1));
        assertFalse(isPalindromeTest(line2));
        assertTrue(isPalindromeTest(line3));
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                --j;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                ++i;
                --j;
            }
        }
        return true;
    }
}
