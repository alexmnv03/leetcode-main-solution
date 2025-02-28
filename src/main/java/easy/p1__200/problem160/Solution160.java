package easy.p1__200.problem160;

import static org.junit.Assert.assertEquals;

import common.ListNode;

public class Solution160 {

    public static ListNode getIntersectionNodeTest(ListNode headA, ListNode headB) {
        return getIntersectionNode(headA, headB);
    }

    private static ListNode headA;
    private static ListNode headB;
    private static ListNode expected;

    public static void main(String[] args) {
        headB = new ListNode(2);
        headB.next = new ListNode(3);
        expected = new ListNode(3);

        ListNode listA = ListNode.createTestData("[4,1,8,4,5]");
        ListNode listB = ListNode.createTestData("[5,6,1,8,4,5]");
        //ListNode listNode3 = ListNode.createTestData("[1]");

        //Error
        //assertEquals(listNode3, getIntersectionNode(listA, listB));
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
