package easy.p1__200.problem028;

import static org.junit.Assert.assertEquals;

public class Solution28 {

    public static int strStrTest(String haystack, String needle) {
        return 1;
    }

    public static void main(String[] args) {
        String haystackTest = "12345";
        String needleTest = "23";
        System.out.println(strStr(haystackTest, needleTest));
        int number = strStr(haystackTest, needleTest);
        assertEquals(1, number);
        int numberTest = strStrTest(haystackTest, needleTest);
        assertEquals(1, numberTest);


        needleTest = "";
        System.out.println(strStr(haystackTest, ""));
        number = strStr(haystackTest, needleTest);
        assertEquals(0, number);
        numberTest = strStrTest(haystackTest, needleTest);
        assertEquals(1, numberTest);

    }

    public static int strStr(String haystack, String needle) {
        int lenHaystack = haystack.length(), lenNeedle = needle.length();
        if (lenHaystack < lenNeedle) return -1;
        for (int pos = 0; ; pos++) {
            // Если еще не нашли и остаток lenHaystack меньше lenNeedle, то выходим
            if (lenNeedle > lenHaystack - pos) return -1;
            // В цикле сравниваем две строки посимвольно, увеличивая счетчик при каждом совпадении
            for (int count = 0; ; count++) {
                // Если счетчик равен длинне строки, значит исходная позиция и есть искомая
                if (count == lenNeedle) return pos;
                // если нашил не совпадение сиволов, то выходим из цикла и перемещаемся на следующую позицию
                if (haystack.charAt(pos + count) != needle.charAt(count)) break;
            }
        }
    }

}
