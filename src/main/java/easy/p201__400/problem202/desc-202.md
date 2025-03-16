Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.


Напишите алгоритм для определения, является ли число n счастливым.

Счастливое число - это число, определенное следующим способом:

Начиная с любого натурального числа, замените число суммой квадратов его цифр.
Повторяйте процесс до тех пор, пока число не станет равным 1 (где оно и останется), или оно бесконечно повторяется в цикле, который не включает 1.
Те числа, для которых этот процесс заканчивается на 1, являются счастливыми.
Верните true, если n - счастливое число, и false, если нет.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
