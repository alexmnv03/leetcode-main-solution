package easy.p1__200.problem083;

import static org.junit.Assert.assertEquals;

import common.ListNode;

public class Solution83 {

    public static ListNode deleteDuplicatesTest(ListNode head) {
        return deleteDuplicates(head);
    }

    public static void main(String[] args) {
        ListNode.print(deleteDuplicates(ListNode.createTestData("[1,1,2]")));
        ListNode.print(deleteDuplicates(ListNode.createTestData("[1,1,2,3,3]")));
        ListNode listNode1 = ListNode.createTestData("[1,2]");
        ListNode listNode2 = ListNode.createTestData("[1,2,3]");
        assertEquals(listNode1, deleteDuplicates(ListNode.createTestData("[1,1,2]")));
        assertEquals(listNode2, deleteDuplicates(ListNode.createTestData("[1,1,2,3,3]")));

        assertEquals(listNode1, deleteDuplicatesTest(ListNode.createTestData("[1,1,2]")));
        assertEquals(listNode2, deleteDuplicatesTest(ListNode.createTestData("[1,1,2,3,3]")));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
