package easy.p1__200.problem0021;

import static org.junit.Assert.assertEquals;

import common.LinkedListUtils;
import common.ListNode;
import java.util.Arrays;

public class Solution21 {

    public static ListNode mergeTwoListsTest(ListNode list1, ListNode list2) {
        return mergeTwoLists(list1, list2);
    }

    public static void main(String[] args) {
        ListNode listNode01 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3, 5));
        ListNode listNode02 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 4, 6));
        assertEquals(
            LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 2, 3, 4, 5, 6)),
            mergeTwoLists(listNode01, listNode02));

        ListNode listNode03 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3, 5));
        ListNode listNode04 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 4, 6));
        assertEquals(
            LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 2, 3, 4, 5, 6)),
            mergeTwoListsTest(listNode03, listNode04));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
