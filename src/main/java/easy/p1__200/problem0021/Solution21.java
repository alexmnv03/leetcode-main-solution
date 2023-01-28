package easy.p1__200.problem0021;

import common.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            // За основание берем list1
            // Вызываем этот же метод, но без первого объекта из list1
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // За основание берем list2
            // Вызываем этот же метод, но без первого объекта из list1
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
