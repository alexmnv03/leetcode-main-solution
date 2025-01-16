package easy.p1__200.problem110;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import common.TreeNode;

public class Solution110 {

    public static boolean isBalancedTest(TreeNode root) {
        return isBalanced(root);
    }

    public static void main(String[] args) {
        TreeNode listNode01 = TreeNode.createTestData("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]");
        TreeNode listNode02 = TreeNode.createTestData("[1,2,2,3,3,null,null,4,4]");
        TreeNode.print(listNode01);
        TreeNode.print(listNode02);
        System.out.println(isBalanced(listNode01));
        System.out.println(isBalanced(listNode02));

        assertTrue(isBalanced(listNode01));
        assertFalse(isBalanced(listNode02));

        assertTrue(isBalancedTest(listNode01));
        assertFalse(isBalancedTest(listNode02));

    }

    public static boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private static int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left);
        if (l == -1) return -1;
        int r = helper(node.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }

}
