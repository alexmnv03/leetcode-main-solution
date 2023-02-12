package easy.p601__800.problem0704;

public class Solution704 {

    public int search(int[] nums, int target) {
        // Суть алгоритма заключается в следующем
        // мы каждый раз делим массив пополам и проверяем не является ли середина искомым числом,
        // если нет то определяем в какой половине массива оно находится, после чего берем эту половину массива как рабочую

        // Опредлеим указатели начала и конца области поиска
        int start = 0;
        int end = nums.length - 1;
        // как только указатели сравнялись выходим из цикла
        while(start < end) {
            // находим середину области
            int middle = start + (end - start) / 2;
            // Если это и есть искомое число
            if (nums[middle] == target){
                return middle;
            }
            // иначе
            else if (nums[middle] > target) {
                // берем левую часть области, добавялем смещенеие, т.к. вы проверили середеину
                end = middle - 1;
            } else {
                // берем правую часть области, добавялем смещенеие, т.к. вы проверили середеину
                start = middle + 1;
            }
        }

        // делаем проверку последнего числа полученного в цикле
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

}
