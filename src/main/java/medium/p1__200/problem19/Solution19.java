package medium.p1__200.problem19;

import static org.junit.Assert.assertEquals;

import common.LinkedListUtils;
import common.ListNode;

public class Solution19 {

    private static ListNode head;
    private static ListNode expected;

    public static ListNode removeNthFromEndTest(ListNode head, int n) {
        Solution19.Solution1 solution1 = new Solution19.Solution1();
        return solution1.removeNthFromEnd(head, n);
    }

    public static void main(String[] args) {
        Solution19.Solution1 solution1 = new Solution19.Solution1();

        head = LinkedListUtils.contructLinkedList(new int[] {1, 2, 3, 4, 5});
        expected = LinkedListUtils.contructLinkedList(new int[] {1, 2, 3, 5});
        assertEquals(expected, solution1.removeNthFromEnd(head, 2));
        head = LinkedListUtils.contructLinkedList(new int[] {1, 2, 3, 4, 5});
        assertEquals(expected, removeNthFromEndTest(head, 2));

        head = LinkedListUtils.contructLinkedList(new int[] {1, 2});
        expected = LinkedListUtils.contructLinkedList(new int[] {1});
        assertEquals(expected, solution1.removeNthFromEnd(head, 1));
        head = LinkedListUtils.contructLinkedList(new int[] {1, 2});
        assertEquals(expected, removeNthFromEndTest(head, 1));


        head = LinkedListUtils.contructLinkedList(new int[] {1});
        expected = LinkedListUtils.contructLinkedList(new int[] {});
        assertEquals(expected, solution1.removeNthFromEnd(head, 1));
        head = LinkedListUtils.contructLinkedList(new int[] {1});
        assertEquals(expected, removeNthFromEndTest(head, 1));
    }

    public static class Solution1 {
        /*
         * Naive/most straightforward approach:
         * go through the list, find its total length, then go through the list a second time:
         * this time, pause at the delta point, then assign its next.next pointer to next.
         * This approach has to traverse the list twice, not one-pass.
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = head;
            int len = 0;
            while (temp != null) {
                temp = temp.next;
                len++;
            }
            if (n == len) {
                return head.next;
            }

            temp = head;
            int cut = len - n;
            while (cut-- > 1) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
                return head;
            }
            return null;
        }
    }

    public static class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // this approach uses two pointers, fast moves first for n nodes, when fast reaches n,
            // then we start to move slow
            // then, when fast reaches null, slow reaches the point where the node should be
            // deleted.
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = head;
            ListNode fast = head;
            int tempN = n;
            while (tempN-- > 0) {
                fast = fast.next;
            }

            if (fast == null) {
                if (n > 0) {
                    // this is for cases like this: [1,2] 2 or [1,2,3,4] 4, namely, remove the head
                    // of
                    // the list and return the second node from the original list
                    dummy.next = dummy.next.next;
                }
                return dummy.next;
            }

            fast = fast.next; // we'll have to move fast pointer one node forward before moving the
            // two together, this way,
            // when fast reaches null, slow will be at the previous node to the node that should be
            // deleted, thus, we can change the next pointer easily

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            if (slow.next != null) {
                slow.next = slow.next.next;
            }
            return dummy.next;
        }
    }

    public static class Solution3 {
        // a more concise version using the same idea
        // i.e. sliding window
        // Time: O(n)
        // Space: O(1)
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode slow = pre;
            ListNode fast = pre;
            while (fast.next != null) {
                if (n <= 0) {
                    slow = slow.next;
                }
                fast = fast.next;
                n--;
            }
            if (slow.next != null) {
                slow.next = slow.next.next;
            }
            return pre.next;
        }
    }

    public static class Solution4 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode fast = dummy, slow = dummy;
            while (n-- > 0) {
                fast = fast.next;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
