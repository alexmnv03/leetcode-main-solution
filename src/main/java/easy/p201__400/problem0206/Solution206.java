package easy.p201__400.problem0206;

import common.ListNode;

public class Solution206 {

    public ListNode reverseList(ListNode head) {
        /**
         * Для решения задачи нам необходимо у каждого элемента заменить значение поля next на
         * значение его предшественника
         * Например:
         * 21 - номер n-го элемента, у которого next указывает на 25
         * 25 - номер (n + 1)-го элемента, у которого next указывает на 18
         * 18 - номер (n + 2)-го элемента, у которого next указывает на ...
         * Нам необходимо изменить поле next у 25 элемента, чтобы оно указывало на 21 элемент
         */
        ListNode reversNode = null; // т.к. это будет последний элемент, поэтому начинаем с null
        ListNode curNode = head; //берем текущий элемент
        while (curNode != null) {
            ListNode next = curNode.next; //берем следующий элемент (n + 1)
            curNode.next = reversNode; // меняем у текущего элемента поле next
            reversNode = curNode; // присваиваем обновленный список нашей переменной
            curNode = next; //берем текущий элемент (n)
        }
        return reversNode;
    }

}
