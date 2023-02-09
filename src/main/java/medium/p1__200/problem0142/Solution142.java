package medium.p1__200.problem0142;

import common.ListNode;

public class Solution142 {

    public ListNode detectCycle(ListNode head) {
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
