package easy.p1__200.problem144;

import static org.junit.Assert.assertEquals;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution144 {

    public static List<Integer> preorderTraversalTest(TreeNode root) {
        //dfsTest(root);
        return preorderTraversal(root);
    }

    private static void dfsTest(TreeNode root) {
        dfs(root);
    }


    public static void main(String[] args) {
        TreeNode listNode1 = TreeNode.createTestData("[1,null,2,3]");
        TreeNode listNode2 = TreeNode.createTestData("[1,2,3,4,5,null,8,null,null,6,7,9]");

        TreeNode listNode11 = TreeNode.createTestData("[1,null,2,3]");
        TreeNode listNode12 = TreeNode.createTestData("[1,2,3,4,5,null,8,null,null,6,7,9]");

        List<Integer> list1 = List.of(
            1, 2
        );
        List<Integer> list2 = List.of(
            1, 2, 1, 2, 4, 5, 6, 7, 3, 8
        );

        //System.out.println(preorderTraversal(listNode1));
        //System.out.println(preorderTraversal(listNode2));


        assertEquals(list1, preorderTraversal(listNode1));
        assertEquals(list2, preorderTraversal(listNode2));

        //assertEquals(list1, preorderTraversalTest(listNode11));
        //assertEquals(list2, preorderTraversalTest(listNode12));

    }

    static private List<Integer> ans = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static List<Integer> preorderTraversalOther(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                TreeNode prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    ans.add(root.val);
                    prev.right = root;
                    root = root.left;
                } else {
                    prev.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
