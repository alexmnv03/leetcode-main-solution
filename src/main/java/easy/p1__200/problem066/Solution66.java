package easy.p1__200.problem066;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

public class Solution66 {

    public static int[] plusOneTest(int[] digits) {
        return plusOne(digits);
    }

    public static void main(String[] args) {
        int[] digits = plusOne(new int[]{9, 9, 9});
        int[] digitsTest = plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(digits));
        assertArrayEquals(new int[]{1, 0, 0, 0}, digits);
        assertArrayEquals(new int[]{1, 0, 0, 0}, digitsTest);

        digits = plusOne(new int[]{4,3,9,9});
        digitsTest = plusOne(new int[]{4,3,9,9});
        System.out.println(Arrays.toString(digits));
        assertArrayEquals(new int[]{4, 4, 0, 0}, digits);
        assertArrayEquals(new int[]{4, 4, 0, 0}, digitsTest);

        digits = plusOne(new int[]{4,3,2,1});
        digitsTest = plusOne(new int[]{4,3,2,1});
        System.out.println(Arrays.toString(digits));
        assertArrayEquals(new int[]{4, 3, 2, 2}, digits);
        assertArrayEquals(new int[]{4, 3, 2, 2}, digitsTest);

    }

    public static int[] plusOne(int[] digits) {
        int lenDigits = digits.length - 1;
        // Если последняя цифра < 9, то просто инкрементим ее
        if (digits[lenDigits] < 9) {
            digits[lenDigits] = ++digits[lenDigits];
        } else {
            do { // будем приравнивать последнюю цифру 0, пока предыдудщая есть и = 9
                digits[lenDigits--] = 0;
            } while (lenDigits >= 0 && digits[lenDigits] == 9);
            // Если у нас случай, когда все были 9 и теперь даже первое число = 0,
            // то увеличм массив на 1 и присвоив 1 первому числу, остальные по умолчанию = 0
            if (digits[0] == 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
                //Инчаче прссто инкрементим последнее число массива, которое не равно 9
            } else {
                ++digits[lenDigits];
            }
        }
        return digits;
    }

}
