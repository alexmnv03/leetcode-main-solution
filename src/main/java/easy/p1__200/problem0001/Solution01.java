package easy.p1__200.problem0001;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {

    // Самы простой вариант решения путем перебора всех чисел
    // Он показал 32% по скорости
    public int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }

    /**
     * Рассмотрим другой вариант решения
     * Этот способ показал 68% по скорости
     */
    public int[] twoSumMap(int[] nums, int target) {
        int[] out = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        /*
        Сохраним в мапу все значения массива, при этом ключ это значение яейки массива, а
        величина - это текущий индекс.
         Суть алгоритма в следующем:
         target = x + y где x и y - искомые значения из массива
         перебираем все значения массива, т.е. получаем число x
         зная target находим y
         и если такое число есть в нашей мапе, то достаем его значение, которое является индексом
         массива, а если нет, то добавим это число в нашу мапу
         */
        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (map.containsKey(y)) {
                out[1] = map.get(y);
                out[0] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return out;
    }
}
