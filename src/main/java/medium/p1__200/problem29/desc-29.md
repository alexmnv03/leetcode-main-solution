29. Divide Two Integers
    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.


Учитывая два целых числа, разделяемое на делимое и делитель, разделите два целых числа без использования операций умножения, деления и модуляции.

При целочисленном делении должно получаться сокращение до нуля, что означает потерю дробной части. Например, значение 8,345 будет усечено до 8, а значение -2,7335 будет усечено до -2.

Верните частное после деления делимого на делитель.

Примечание: Предположим, что мы имеем дело со средой, которая может хранить только целые числа в пределах 32-разрядного диапазона целых чисел со знаком: [-231, 231 − 1]. Для этой задачи, если частное строго больше 231 - 1, то верните значение 231 - 1, а если частное строго меньше -231, то верните значение -231.


Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
