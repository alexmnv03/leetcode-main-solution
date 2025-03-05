package easy.p1__200.problem168;

import static org.junit.Assert.assertEquals;

public class Solution168 {
    public static String convertToTitleTest(int columnNumber) {
        return convertToTitle(columnNumber);
    }

    public static void main(String[] args) {

        assertEquals("APSM", convertToTitle(28899));
        assertEquals("A", convertToTitle(1));
        assertEquals("AB", convertToTitle(28));
        assertEquals("ZY", convertToTitle(701));

        assertEquals("APSM", convertToTitleTest(28899));
        assertEquals("A", convertToTitleTest(1));
        assertEquals("AB", convertToTitleTest(28));
        assertEquals("ZY", convertToTitleTest(701));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            --columnNumber;
            res.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
