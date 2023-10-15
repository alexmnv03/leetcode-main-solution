package easy.p1__200.problem0013;

import java.util.Map;

public class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> data = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int result = 0;
        int prev = Integer.MAX_VALUE;
        for (char c: s.toCharArray()) {
            int value = data.get(c);
            if (value <= prev) {
                // Если значение больше предыдущего, то просто его добавляем
                result += value;
            } else { // а если меньше (IV)
                result += value;  // добавялем значение
                // Сначала вычитаем предыдущее, которое мы прибавили на прошлом шаге, т.к. его не
                // надо прибавялть, а второй раз вычитаем, т.к. текущее значение надо уменьшить на
                // это число
                result -= 2 * prev;
            }
            prev = value;
        }
        return result;
    }
}
