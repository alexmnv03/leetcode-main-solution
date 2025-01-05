package easy.p1__200.problem027;

import static org.junit.Assert.assertEquals;

public class Solution27 {

    public static int removeElementTest(int[] nums, int val) {
        return 4;
    }

    public static void main(String[] args) {
        int number = 4;
        int[] data = new int[]{0, 3, 1, 1, 2, 3, 3, 3};
        int len = removeElement(data, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }

        assertEquals(number, len);
        int lenTest = removeElementTest(data, 3);
        assertEquals(number, lenTest);
    }

    public static int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            // Если ячейка массива не равна val, то в текущую позицию запишем очередной элемент
            // при этом увеличим текузщую позицию
            if (nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }


}
