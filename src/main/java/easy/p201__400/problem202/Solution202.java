package easy.p201__400.problem202;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {

    public static boolean isHappyTest(int n) {
        return isHappy(n);
    }

    public static void main(String[] args) {
        assertTrue(isHappy(7));
        assertTrue(isHappy(19));
        assertFalse(isHappy(2));

        assertTrue(isHappyTest(7));
        assertTrue(isHappyTest(19));
        assertFalse(isHappyTest(2));

    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> seen = new HashSet();
        seen.add(n);
        int result = 0;
        while (result != 1) {
            result = getResult(n);
            if (seen.contains(result)) {
                return false;
            }
            seen.add(result);
            n = result;
        }
        return true;
    }

    private static Integer getResult(int num) {
        int result = 0;
        while (num != 0) {
            result += (num % 10) * (num % 10);
            num /= 10;
        }
        return result;
    }
}
