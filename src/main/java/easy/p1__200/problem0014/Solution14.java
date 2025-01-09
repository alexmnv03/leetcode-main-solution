package easy.p1__200.problem0014;

import static org.junit.Assert.assertEquals;

public class Solution14 {

    public static String longestCommonPrefixTest(String[] strs) {
        return longestCommonPrefix(strs);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abc", "abcd", "ab"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assertEquals("ab", longestCommonPrefix(new String[]{"abc", "abcd", "ab"}));
        assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));

        assertEquals("ab", longestCommonPrefixTest(new String[]{"abc", "abcd", "ab"}));
        assertEquals("fl", longestCommonPrefixTest(new String[]{"flower","flow","flight"}));
        assertEquals("", longestCommonPrefixTest(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        // Берем за основу первую строку, она будет нашим префиксом
        String result = strs[0];
        int i = 1;
        String current;
        // Цикл пока наша строка не станет = null или пока не переберем все строки
        while (result.length() > 0 && i < strs.length) {
            // Как только попадается строка меньшего размера, то урезаем нашу строку до ее размера
            if (result.length() > strs[i].length()) {
                result = result.substring(0, strs[i].length());
            }
            // Берем часть текущей и урезаем до размера = нашей строке
            current = strs[i].substring(0, result.length());
            // и сравниваем их
            if (!current.equals(result)) {
                // Если строки не равны, то уменьшаем нашу строку на один символ
                result = result.substring(0, result.length() - 1);
            } else {
                // Если строки равны, то переходим к сравнению следующей строки
                i++;
            }
        }
        return result;
    }
}
