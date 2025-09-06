package medium.p1__200.problem24;

import static org.junit.Assert.assertEquals;

import common.LinkedListUtils;
import common.ListNode;
import java.util.Arrays;
import java.util.List;

public class Solution24 {

    private static ListNode head;
    private static ListNode expected;

    public static ListNode swapPairsTest(ListNode head) {
        Solution24.Solution3 solution3 = new Solution24.Solution3();
        return solution3.swapPairs(head);
    }

    public static void main(String[] args) {
        Solution24.Solution3 solution3 = new Solution24.Solution3();
        head = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3, 4));
        expected = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 1, 4, 3));
        assertEquals(expected, solution3.swapPairs(head));

        solution3 = new Solution24.Solution3();
        head = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1));
        expected = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1));
        assertEquals(expected, solution3.swapPairs(head));

        solution3 = new Solution24.Solution3();
        head = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3));
        expected = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 1, 3));
        assertEquals(expected, solution3.swapPairs(head));

        solution3 = new Solution24.Solution3();
        head = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3, 4));
        expected = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 1, 4, 3));
        assertEquals(expected, swapPairsTest(head));

        solution3 = new Solution24.Solution3();
        head = LinkedListUtils.createSinglyLinkedList(List.of(1));
        expected = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1));
        assertEquals(expected, swapPairsTest(head));

        solution3 = new Solution24.Solution3();
        head = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3));
        expected = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 1, 3));
        assertEquals(expected, swapPairsTest(head));
    }

    public static class Solution1 {
        /*
         * Recursive solution.
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode second = head.next;
            ListNode third = second.next;
            second.next = head;
            head.next = swapPairs(third);
            return second;
        }
    }

    public static class Solution2 {
        /*
         * Iterative approach:
         * My completely original on 10/24/2021.
         */
        public ListNode swapPairs(ListNode head) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode tmp = pre;
            while (head != null) {
                ListNode third;
                ListNode first = head;
                ListNode second = head.next;
                if (second == null) {
                    break;
                } else {
                    third = head.next.next;
                    second.next = first;
                    first.next = third;
                    tmp.next = second;
                    tmp = tmp.next.next;
                }
                head = third;
            }
            return pre.next;
        }
    }

    public static class Solution3 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode t = swapPairs(head.next.next);
            ListNode p = head.next;
            p.next = head;
            head.next = t;
            return p;
        }
    }
}
