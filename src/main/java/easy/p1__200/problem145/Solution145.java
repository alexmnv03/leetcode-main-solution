package easy.p1__200.problem145;

import static org.junit.Assert.assertEquals;

import common.TreeNode;
import common.TreeUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution145 {

    private static final List<Integer> ans = new ArrayList<>();

    public static List<Integer> postorderTraversalTest(TreeNode root) {
        return postorderTraversal(root);
    }

    private static void dfsTest(TreeNode root) {
        dfs(root);
    }

    public static void main(String[] args) {
        TreeNode listNode1 = TreeNode.createTestData("[1,2,3,4,5,null,8,null,null,6,7,9]");
        //System.out.println(postorderTraversal(listNode1));
        List<Integer> list1 = List.of(
            4, 6, 7, 5, 2, 8, 3, 1
        );
        List<Integer> list2 = List.of(
            1
        );
        TreeNode listNode01 = TreeNode.createTestData("[1,2,3,4,5,null,8,null,null,6,7,9]");

        TreeNode listNode2 =
            TreeUtils.constructBinaryTree(
                Arrays.asList(1));
        TreeUtils.printBinaryTree(listNode2);

        //assertEquals(list1, postorderTraversal(listNode1));

        assertEquals(list1, postorderTraversalTest(listNode01));
        //assertEquals(list2, postorderTraversalTest(listNode02));
        //assertEquals(list2, postorderTraversal(listNode2));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        ans.add(root.val);
    }

    public static List<Integer> postorderTraversalLD(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            ans.addFirst(node.val);
            if (node.left != null) {
                stk.push(node.left);
            }
            if (node.right != null) {
                stk.push(node.right);
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversalLL(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        while (root != null) {
            if (root.right == null) {
                ans.addFirst(root.val);
                root = root.left;
            } else {
                TreeNode next = root.right;
                while (next.left != null && next.left != root) {
                    next = next.left;
                }
                if (next.left == null) {
                    ans.addFirst(root.val);
                    next.left = root;
                    root = root.right;
                } else {
                    next.left = null;
                    root = root.left;
                }
            }
        }
        return ans;
    }
}
