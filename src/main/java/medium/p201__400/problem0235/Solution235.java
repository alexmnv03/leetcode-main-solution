package medium.p201__400.problem0235;

import common.TreeNode;

public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        while (true) {
            int rVal = root.val;
            // Если обе искомые ноды меньше значения текущей вершины, то идем в левую часть дерева
            if ((pVal < rVal) && (qVal < rVal))
                root = root.left;
                // Если обе искомые ноды больше значения текущей вершины, то идем в правую часть дерева
            else if ((pVal > rVal) && (qVal > rVal))
                root = root.right;
            else return root;
        }
    }

}
