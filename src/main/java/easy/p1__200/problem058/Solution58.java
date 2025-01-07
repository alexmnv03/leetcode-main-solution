package easy.p1__200.problem058;

import static org.junit.Assert.assertEquals;

public class Solution58 {

    public static int lengthOfLastWordTest(String s) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("word "));
        System.out.println(lengthOfLastWord("hello world"));

        assertEquals(4, lengthOfLastWord("word "));
        assertEquals(5, lengthOfLastWord("hello world"));

        assertEquals(4, lengthOfLastWordTest("word "));
        assertEquals(5, lengthOfLastWordTest("hello world"));
    }

    public static int lengthOfLastWord(String s) {
        int p = s.length() - 1;
        //Удалим все последнии пробелы в цикле
        while (p >= 0 && s.charAt(p) == ' ') p--;
        //Последняя позиция
        int end = p;
        //Цикл до первого пробела
        while (p >= 0 && s.charAt(p) != ' ') p--;
        return end - p;
    }

}
