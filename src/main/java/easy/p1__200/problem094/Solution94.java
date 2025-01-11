package easy.p1__200.problem094;

import static org.junit.Assert.assertEquals;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {

    public static List<Integer> inorderTraversalTest(TreeNode root) {
        return inorderTraversal(root);
    }

    // Не получилось проверить, не получается создать объект с нулевым элементом
    public static void main(String[] args) {
        System.out.println(inorderTraversal(TreeNode.createTestData("[1,null,2,3]")));
        System.out.println(inorderTraversal(TreeNode.createTestData("[1,2,3,4,5,null,8,null,null,6,7,9]")));
        System.out.println(inorderTraversal(TreeNode.createTestData("[]")));
        //System.out.println(inorderTraversal(TreeNode.createTestData("[1]")));
        TreeNode listNode1 = TreeNode.createTestData("[1,3,2]");
        //assertEquals(listNode1, inorderTraversal(TreeNode.createTestData("[1,null,2,3]")));

        TreeNode listNode2 = TreeNode.createTestData("[4,2,6,5,7,1,3,9,8]");
        //assertEquals(listNode2, inorderTraversal(TreeNode.createTestData("[1,2,3,4,5,null,8,null,null,6,7,9]")));
        TreeNode listNode3 = TreeNode.createTestData("[]");
        //assertEquals(listNode3, inorderTraversal(TreeNode.createTestData("[]")));
//        TreeNode listNode4 = TreeNode.createTestData("[null]");
//        assertEquals(listNode4, inorderTraversal(TreeNode.createTestData("[null]")));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

}
