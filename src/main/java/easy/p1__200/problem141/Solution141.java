package easy.p1__200.problem141;

import static org.junit.Assert.assertFalse;

import common.ListNode;

public class Solution141 {

    public static boolean hasCycleTest(ListNode head) {
        return hasCycle(head);
    }

    public static void main(String[] args) {
        //ListNode listNode1 = LinkedListUtils.contructLinkedList(new int[] {3,2,0,-4});
        ListNode listNode1 = ListNode.createTestData("[3,2,0,-4]");
        ListNode listNode2 = ListNode.createTestData("[1,2]");
        ListNode listNode3 = ListNode.createTestData("[1]");


        System.out.println(hasCycle(listNode1));
        System.out.println(hasCycle(listNode2));
        System.out.println(hasCycle(listNode3));

        assertFalse(hasCycle(listNode1));
        assertFalse(hasCycle(listNode2));
        assertFalse(hasCycle(listNode3));

        assertFalse(hasCycleTest(listNode1));
        assertFalse(hasCycleTest(listNode2));
        assertFalse(hasCycleTest(listNode3));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
