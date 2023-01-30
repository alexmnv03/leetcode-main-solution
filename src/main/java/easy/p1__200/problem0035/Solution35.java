package easy.p1__200.problem0035;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
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
