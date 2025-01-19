package easy.p1__200.problem112;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import common.TreeNode;

public class Solution112 {

    public static boolean hasPathSumTest(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum);
    }

    public static void main(String[] args) {
        //TreeNode listNode01 = TreeNode.createTestData("[]");
        TreeNode listNode01 = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        TreeNode listNode02 = TreeNode.createTestData("[1,2,3]");
        TreeNode listNode03 = TreeNode.createTestData("[]");
        TreeNode.print(listNode01);
        TreeNode.print(listNode02);
        TreeNode.print(listNode03);
        System.out.println(hasPathSum(listNode01, 22));
        System.out.println(hasPathSum(listNode02, 5));
        System.out.println(hasPathSum(listNode01, 22));

        assertTrue(hasPathSum(listNode01, 22));
        assertFalse(hasPathSum(listNode01, 5));
        assertFalse(hasPathSum(listNode03, 0));

        assertTrue(hasPathSumTest(listNode01, 22));
        assertFalse(hasPathSumTest(listNode01, 5));
        assertFalse(hasPathSumTest(listNode03, 0));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
