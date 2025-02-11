package easy.p1__200.problem119;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {

    public static List<Integer> getRowTest(int rowIndex) {
        return getRow(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow(0));
        System.out.println(getRow(1));

        List<Integer> list3 = List.of(1, 3, 3, 1);
        List<Integer> list0 = List.of(1);
        List<Integer> list1 = List.of(1, 1);

        assertEquals(list3 , getRow(3));
        assertEquals(list0 , getRow(0));
        assertEquals(list1 , getRow(1));

        assertEquals(list3 , getRowTest(3));
        assertEquals(list0 , getRowTest(0));
        assertEquals(list1 , getRowTest(1));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }

}
