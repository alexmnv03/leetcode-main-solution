package easy.p1__200.problem0009;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution09 {

    public static boolean isPalindromeTest(int x) {
        return isPalindrome(x);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-1));
        System.out.println(isPalindrome(10010));

        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(111));
        System.out.println(isPalindrome(222222222));

        assertFalse(isPalindrome(-1));
        assertFalse(isPalindrome(10010));

        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(11));
        assertTrue(isPalindrome(111));
        assertTrue(isPalindrome(222222222));

        assertFalse(isPalindromeTest(-1));
        assertFalse(isPalindromeTest(10010));

        assertTrue(isPalindromeTest(0));
        assertTrue(isPalindromeTest(11));
        assertTrue(isPalindromeTest(111));
        assertTrue(isPalindromeTest(222222222));

    }
    
    // Самый простой вариант - преобразуем в строку в цикле переворачиваем ее и сравниваем
    // по скорости 6,29%
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String str = String.valueOf(x);
        String revers = "";
        for (int i = 0; i < str.length(); i++) {
            revers = str.charAt(i) + revers;
        }
        if (str.equals(revers)) {
            return true;
        } else {
            return false;
        }
    }

    /* Попробуем другой алгоритм - будем извлекать из исходного числа по одной цифре и добавлять
    ее в новое в обратном порядке - по скорости 96,19%
     */
    public boolean isPalindromeDigit(int x) {
        if (x < 0)
            return false;
        int revers = 0;
        int current = x;
        while (current > 0) {
            int digit = current % 10;
            current /= 10;
            // В этом варианте возможно переполнение при получении обратного числа 2 147 483 647
            // получим 7 463 847 412 - превышает int.max
            // Поэтому добавим проверку
            // если число меньше MAX_VALUE / 10 то можно увеличивать его на порядок
            // а если число равно MAX_VALUE / 10 то надо убедиться что добавляемое число не
            // превышает послдений разряд MAX_VALUE
            if ((revers < Integer.MAX_VALUE / 10)
                || ((revers == Integer.MAX_VALUE / 10) && (digit <= Integer.MAX_VALUE % 10))
            ) {
                revers = revers * 10 + digit;
            } else {
                return false;
            }
        }
        return revers == x;
    }

}
