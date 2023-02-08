Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Учитывая начало связанного списка, верните узел, с которого начинается цикл. Если цикла нет, верните null.

В связанном списке есть круг, если в списке есть какой-то узел, до которого можно снова добраться, непрерывно следуя за следующим указателем. Внутренне pos используется для обозначения индекса узла, к которому подключен следующий указатель tail (0-индексированный). Это равно -1, если цикла нет. Обратите внимание, что pos не передается в качестве параметра.

Не изменяйте связанный список.


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1

Input: head = [1,2], pos = 0
Output: tail connects to node index 0

Данная задача решается с помощью алгоритма двух указателей - медленного и быстрого,
суть которого заключается в следующем:
оба указателя стартуют из одного узла, но медленный выполняет одни шаг, а быстрый два шага за раз.
и если связанный список имеет кольцо, то эти указатели обязательно должны встретиться
