Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

         Необходимо найти самую нижнюю вершину, для которой обе заданные ноды являются
         потомками, при этом нода для самой себя тоже является потомком
         Мы имеем два пути от корня до каждой ноды
         Если мы найдем самую нижнюю общую вершину по этим путям это и будет искомая нода
         Можно построить два пути и искать в них общую вершину, а можно сделать по другому
         Из главной вершины начинаем двигаться по дереву в сторону обоих нод, т.е. идем по
         общему, придерживаясь простого алгоритма, который основан на том правиле, что в левой
         ветке все ноды должны быть меньше текущей вершины, а в правой больше :
         1. Если обе искомые ноды меньше значения текущей вершины, то идем в левую часть дерева
         2. Если обе искомые ноды больше значения текущей вершины, то идем в правую часть дерева
         3. Иначе мы находимся на развилке, и текущая вершина является искомой

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
