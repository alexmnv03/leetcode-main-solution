package medium.p1__200.problem113;

import static org.junit.Assert.assertEquals;

import common.TreeNode;
import common.TreeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution113 {

    private static TreeNode root;

    public static List<List<Integer>> pathSumTest(TreeNode root, int sum) {
        return pathSum(root, sum);
    }

    public static void main(String[] args) {
        //TreeNode listNode01 = TreeNode.createTestData("[]");
        root =
            TreeUtils.constructBinaryTree(
                Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(5, 4, 11, 2));
        expected.add(Arrays.asList(5, 8, 4, 5));
        assertEquals(expected, pathSum(root, 22));
        assertEquals(expected, pathSumTest(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList();
        if (root == null) {
            return allPaths;
        }
        dfs(root, new ArrayList(), allPaths, targetSum);
        return allPaths;
    }

    private static void dfs(TreeNode root, List<Integer> path, List<List<Integer>> allPaths, int sum) {
        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, path, allPaths, sum - root.val);
        }
        if (root.right != null) {
            dfs(root.right, path, allPaths, sum - root.val);
        }
        if (root.left == null && root.right == null) {
            /*Check if sum equals root.val, not sum equals zero!*/
            if (sum == root.val) {
                allPaths.add(new ArrayList(path));
            }
        }
        path.remove(path.size() - 1);
    }
}
