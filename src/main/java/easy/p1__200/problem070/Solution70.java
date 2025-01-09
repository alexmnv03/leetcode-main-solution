package easy.p1__200.problem070;

import static org.junit.Assert.assertEquals;

public class Solution70 {

    public static int climbStairsTest(int n) {
        return climbStairs(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(5));
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
        assertEquals(8, climbStairs(5));

        assertEquals(2, climbStairsTest(2));
        assertEquals(3, climbStairsTest(3));
        assertEquals(8, climbStairsTest(5));
    }

    //для любого заданного n, число способов подняться на вершину лестницы равно f(n), где f(n) - это n-е число Фибоначчи
    public static int climbStairs(int n) {
        int a = 1, count = 1;
        while (--n > 0) {
            count += a;
            a = count - a;
        }
        return count;
    }
}
