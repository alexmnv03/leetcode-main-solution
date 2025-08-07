package medium.p1__200.problem02;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import common.LinkedListUtils;
import common.ListNode;

public class Solution2 {

    private static ListNode l1;
    private static ListNode l2;
    private static ListNode expected;

    public static ListNode addTwoNumbersTest(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2);
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(addTwoNumbers(nums, target)));
        l1 = LinkedListUtils.contructLinkedList(new int[] {2, 4, 3});
        l2 = LinkedListUtils.contructLinkedList(new int[] {5, 6, 4});
        expected = LinkedListUtils.contructLinkedList(new int[] {7, 0, 8});
        assertEquals(expected, addTwoNumbers(l1, l2));


        l1 = LinkedListUtils.contructLinkedList(new int[] {2, 4, 3});
        l2 = LinkedListUtils.contructLinkedList(new int[] {5, 6, 4});
        expected = LinkedListUtils.contructLinkedList(new int[] {7, 0, 8});
        assertEquals(expected, addTwoNumbersTest(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(-1);
        ListNode tmp = pre;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return pre.next;
    }

}
