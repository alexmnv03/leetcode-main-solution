package medium.p1__200.problem0142;

import static common.LinkedListUtils.createSinglyLinkedList;
import static common.LinkedListUtils.printList;

import common.ListNode;
import java.util.Arrays;

public class Solution142 {

    private static ListNode nodeRoot;
    private static ListNode nodeResult;

    public static ListNode detectCycleTest(ListNode head) {
        // Не получилось сделать проверку
        return createSinglyLinkedList(Arrays.asList(3,2,0,-4));
    }

    public static void main(String[] args) {


        nodeRoot = createSinglyLinkedList(Arrays.asList(3,2,0,-4));

        nodeResult = detectCycle(nodeRoot);
        printList(nodeRoot);
        printList(nodeResult);

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // Кольцо найдено
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        /**
         * Теперь найдем точку входа в кольцо
         * a - точка начала цикла
         * b - точка входа в кольцо
         * c - точка встречи двух указателей
         * математически доказано, что отрезок ab == cb
         * т.е. если мы будем двигаться одновременно из точки 'a' и точки 'c' с одной скоростью,
         * то должны встретиться в точке b
         */
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

}
