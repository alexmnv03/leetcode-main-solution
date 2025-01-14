package easy.p1__200.problem104;

import static org.junit.Assert.assertEquals;

import common.TreeNode;

public class Solution104 {
    public static int maxDepthTest(TreeNode root) {
        return maxDepth(root);
    }

    public static void main(String[] args) {
        TreeNode listNode01 = TreeNode.createTestData("[]");
        TreeNode listNode02 = TreeNode.createTestData("[1,2,2,3,4,4,3]");
        TreeNode listNode03 = TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]");

        System.out.println(maxDepth(TreeNode.createTestData("[]")));
        System.out.println(maxDepth(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
        System.out.println(maxDepth(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));
        assertEquals(0, maxDepth(listNode01));
        assertEquals(3, maxDepth(listNode02));
        assertEquals(4, maxDepth(listNode03));

        assertEquals(0, maxDepthTest(listNode01));
        assertEquals(3, maxDepthTest(listNode02));
        assertEquals(4, maxDepthTest(listNode03));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
