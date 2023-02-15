Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

       Необходимо проверить, что двоичное дерево валидно
         т.е. в левом поддереве ключи должны быть строго меньше, а в правом строго больше
         Алгоритм решения следующий определим диапазоны возможных значений для каждого поддерева
         [Integer.MIN_VALUE, Integer.MAX_VALUE] диапазоны возможных значений для корня
         root.val - реальное значение корня
         [Integer.MIN_VALUE, root.val - 1] диапазоны возможных значений для левой части
         [root.val + 1, Integer.MAX_VALUE] диапазоны возможных значений для правой части
