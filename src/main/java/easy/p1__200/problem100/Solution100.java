package easy.p1__200.problem100;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import common.TreeNode;

public class Solution100 {

    public static boolean isSameTreeTest(TreeNode p, TreeNode q) {
        return isSameTree(p, q);
    }

    public static void main(String[] args) {
        TreeNode listNode01 = TreeNode.createTestData("[1,2,2,null,3,null,3]");
        TreeNode listNode02 = TreeNode.createTestData("[1,2,2,null,3,null,3]");
        System.out.println(isSameTree(listNode01, listNode02));
        TreeNode listNode11 = TreeNode.createTestData("[1,2,2,null,3,null,3]");
        TreeNode listNode12 = TreeNode.createTestData("[1,2,2,null,3,null,null]");
        System.out.println(isSameTree(listNode11, listNode12));
        TreeNode listNode21 = TreeNode.createTestData("[1,2,1]");
        TreeNode listNode22 = TreeNode.createTestData("[1,1,2]");
        System.out.println(isSameTree(listNode21, listNode22));
        assertTrue(isSameTree(listNode01, listNode02));
        assertFalse(isSameTree(listNode11, listNode12));
        assertFalse(isSameTree(listNode21, listNode22));

        assertTrue(isSameTreeTest(listNode01, listNode02));
        assertFalse(isSameTreeTest(listNode11, listNode12));
        assertFalse(isSameTreeTest(listNode21, listNode22));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
