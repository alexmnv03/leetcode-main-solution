33. Search in Rotated Sorted Array
    There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Существует целочисленный массив nums, отсортированный в порядке возрастания (с различными значениями).

Перед передачей в вашу функцию nums, возможно, остается повернутым на неизвестный индекс k (1 <= k < nums.длина) таким образом, что результирующий массив будет иметь вид [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (с индексом 0). Например, [0,1,2,4,5,6,7] может быть повернуто влево на 3 индекса и стать [4,5,6,7,0,1,2].

Учитывая массив nums после возможного поворота и целочисленную цель, верните индекс цели, если он находится в числах, или -1, если он не находится в числах.

Вы должны написать алгоритм со сложностью выполнения O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
