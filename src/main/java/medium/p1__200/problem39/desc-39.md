39. Combination Sum
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


При наличии массива различных целых чисел-кандидатов и целевого целевого числа target возвращает список всех уникальных комбинаций кандидатов, в которых выбранные числа суммируются с target. Вы можете возвращать комбинации в любом порядке.

Одно и то же число может быть выбрано из кандидатов неограниченное количество раз. Две комбинации считаются уникальными, если частота, по крайней мере, одного из выбранных чисел различна.

Тестовые примеры генерируются таким образом, чтобы количество уникальных комбинаций, которые в сумме дают целевое значение, составляло менее 150 комбинаций для заданных входных данных.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
