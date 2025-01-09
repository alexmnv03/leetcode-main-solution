package easy.p1__200.problem069;

import static org.junit.Assert.assertEquals;

public class Solution69 {

    public static int mySqrtTest(int x) {
        return mySqrt(x);
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(10));
        System.out.println(mySqrt(8));
        assertEquals(3, mySqrt(10));
        assertEquals(2, mySqrt(8));
        assertEquals(3, mySqrtTest(10));
        assertEquals(2, mySqrtTest(8));
    }

    //Этот код меньше, но по производительности выигрыша нет
    public static int mySqrt(int x) {
        long n = x;
        // Суть решения в том, что мы ищем ближайшее целое число квадрат которого меньше или равен x
        // Чтобы не перебирать по одному все числа была найдена такая закономерность, битовыый сдвиг вправо - это деление на два с огруглением
        // вниз, только быстрее чем деление
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }

    public static int mySqrtBig(int x) {
        if (x < 2)
            return x;
        int left = 1;
        int right = x / 2;
        long n = 0;
        while (left <= right) {
            n = left + (right - left) / 2;
            if ((n * n) == x)
                return (int)n;
            else if ((n * n) > x)
                right = (int)n - 1;
            else
                left = (int)n + 1;
        }
        return right;
    }

}
