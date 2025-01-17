package easy.p1__200.problem111;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import common.TreeNode;
import java.util.LinkedList;

public class Solution111 {

    public static int minDepthTest(TreeNode root) {
        return minDepth(root);
    }

    public static void main(String[] args) {
        //TreeNode listNode01 = TreeNode.createTestData("[]");
        TreeNode listNode01 = TreeNode.createTestData("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]");
        TreeNode listNode02 = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        TreeNode listNode03 = TreeNode.createTestData("[2,null,3,null,4,null,5,null,6]");
        TreeNode.print(listNode01);
        TreeNode.print(listNode02);
        TreeNode.print(listNode03);
        System.out.println(minDepth(listNode01));
        System.out.println(minDepth(listNode02));
        System.out.println(minDepth(listNode03));

        assertEquals(3, minDepth(listNode01));
        assertEquals(2, minDepth(listNode02));
        assertEquals(3, minDepth(listNode03));

        assertEquals(3, minDepthTest(listNode01));
        assertEquals(2, minDepthTest(listNode02));
        assertEquals(3, minDepthTest(listNode03));
    }

    //Более короткое решение  и без LinkedList
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        int l = minDepth(root.left);
//        int r = minDepth(root.right);
//        if (l != 0 && r != 0) return 1 + Math.min(l, r);
//        return l + r + 1;
//    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                if (node.left == null && node.right == null) {
                    return ans;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ++ans;
        }
        return 520;
    }

}
