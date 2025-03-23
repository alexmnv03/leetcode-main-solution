package easy.p1__200.problem027;

import static org.junit.Assert.assertEquals;

public class Solution27 {

    public static int removeElementTest(int[] nums, int val) {
        return removeElement(nums, val);
    }

    public static void main(String[] args) {
        int number = 4;
        int[] data = new int[]{0, 3, 1, 1, 2, 3, 3, 3};
        int[] data02 = new int[]{0,1,2,2,3,0,4,2};
        int len = removeElement(data, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }

        assertEquals(number, len);
        assertEquals(removeElement(data02, 2), 5);
        int[] dataTest = new int[]{0, 3, 1, 1, 2, 3, 3, 3};
        int[] dataTest02 = new int[]{0,1,2,2,3,0,4,2};
        int lenTest = removeElementTest(dataTest, 3);
        assertEquals(number, lenTest);
        assertEquals(removeElementTest(dataTest02, 2), 5);
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
