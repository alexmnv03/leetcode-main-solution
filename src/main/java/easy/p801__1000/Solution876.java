package easy.p801__1000;

import common.ListNode;

public class Solution876 {

    // Решим задачу с помощью двух указателей
    public ListNode middleNode(ListNode head) {

        if (head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;

        //slow перемещается по одному ноду, а fast по двум
        // т.е. когда  fast дойдет до конца массива, slow будет на середине
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null)
            return slow;
        else
            return slow.next;
    }

}
