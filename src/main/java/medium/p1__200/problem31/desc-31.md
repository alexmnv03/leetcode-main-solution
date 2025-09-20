31. Next Permutation
    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.


Перестановка массива целых чисел - это расположение его элементов в последовательности или линейном порядке.

Например, для arr = [1,2,3] ниже приведены все перестановки arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
Следующая перестановка массива целых чисел - это следующая лексикографически большая перестановка его целого числа. Более формально, если все перестановки массива отсортированы в одном контейнере в соответствии с их лексикографическим порядком, то следующая перестановка этого массива - это перестановка, которая следует за ней в отсортированном контейнере. Если такое расположение невозможно, массив должен быть упорядочен в наименьшем возможном порядке (т.е. отсортирован по возрастанию).

Например, следующая перестановка arr = [1,2,3] равна [1,3,2].
Аналогично, следующая перестановка arr = [2,3,1] равна [3,1,2].
В то время как следующая перестановка arr = [3,2,1] равна [1,2,3], потому что [3,2,1] не имеет лексикографической более крупной перестановки.
Задан массив целых чисел nums, найдите следующую перестановку чисел.

Замена должна быть на месте и использовать только постоянную дополнительную память.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
