package easy.p1__200.problem0035;

import static org.junit.Assert.assertEquals;

public class Solution35 {

    public static int searchInsertTest(int[] nums, int target) {
        return searchInsert(nums, target);
    }

    public static void main(String[] args) {
        int[] nums01 = new int[] {1, 3, 5, 6};
        int[] nums02 = new int[] {1};

        assertEquals(2, searchInsert(nums01, 5));
        assertEquals(0, searchInsert(nums02, 1));
        assertEquals(1, searchInsert(nums01, 2));
        assertEquals(4, searchInsert(nums01, 7));

        assertEquals(2, searchInsertTest(nums01, 5));
        assertEquals(0, searchInsertTest(nums02, 1));
        assertEquals(1, searchInsertTest(nums01, 2));
        assertEquals(4, searchInsertTest(nums01, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        // Вариант решения с помощью двух указателей - обычный бинарный поиск
        // каждый раз делим массив пополам и берем нужныю половину и так пока не найдем искомое
        // место
        // Этот вариант показал 100%
        int left = 0;
        int right = nums.length - 1;
        int number = 0;
        while (left <= right) {
            number = left + (right - left) / 2;
            if (nums[number] == target)
                return number;
            else if (nums[number] < target)
                left = number + 1;
            else
                right = number - 1;
        }
        return (nums[number] > target) ? number : (number + 1);
    }

    public int searchInsertShort(int[] nums, int target) {
        // Есть более простой вариант решения, но не смотря на его простоту, нам приходится
        // делать больше итераций чем в предыдущем вариантек, поэтому Этот вариант показал 15%
        int i = 0;
        // мы выйдем из цикла как только наше число станет больше или = текущему числу в массиве,
        // а значит текущая итерация и есть искомое число
        // если совпадений не будет найдено, то выходим по когда будет даостигнут конец массива и
        // искомая позиция как раз за ней
        while (i < nums.length && nums[i] < target) {
            i++;
        }
        return i;
    }
}
