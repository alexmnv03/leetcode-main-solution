package easy.p1__200.problem108;

import static org.junit.Assert.assertEquals;

import common.TreeNode;

public class Solution108 {

    public static TreeNode sortedArrayToBSTTest(int[] nums) {
        return sortedArrayToBST(nums);
    }

    public static void main(String[] args) {
        TreeNode listNode01 = TreeNode.createTestData("[]");
        TreeNode listNode02 = TreeNode.createTestData("[0,-10,5,null,-3,null,9]");
        TreeNode resListNode01 = sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        TreeNode resListNode02 = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        //TreeNode.print(resListNode01);
        TreeNode.print(resListNode02);

        TreeNode resListNodeTest02 = sortedArrayToBST(new int[]{-10,-3,0,5,9});

        assertEquals(listNode02, resListNode02);
        assertEquals(listNode02, resListNodeTest02);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

}
