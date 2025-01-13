package easy.p1__200.problem101;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import common.TreeNode;
import java.util.LinkedList;

public class Solution101 {

    public static boolean isSymmetricTest(TreeNode root) {
        return isSymmetric(root);
    }

    public static void main(String[] args) {
        TreeNode listNode1 = TreeNode.createTestData("[1,2,2,3,4,4,3]");
        TreeNode listNode2 = TreeNode.createTestData("[1,2,2,null,3,null,3]");
        TreeNode listNode3 = TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]");

        System.out.println(isSymmetric(listNode1));
        System.out.println(isSymmetric(listNode2));
        System.out.println(isSymmetric(listNode3));

        assertTrue(isSymmetric(listNode1));
        assertFalse(isSymmetric(listNode2));
        assertFalse(isSymmetric(listNode3));

        assertTrue(isSymmetricTest(listNode1));
        assertFalse(isSymmetricTest(listNode2));
        assertFalse(isSymmetricTest(listNode3));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        TreeNode left, right;
        while (q.size() > 1) {
            left = q.pop();
            right = q.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }


    public boolean isSymmetricSmall(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

}
