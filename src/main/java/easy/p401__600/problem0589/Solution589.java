package easy.p401__600.problem0589;


import common.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        createList(list, root);
        return list;
    }

    public static void createList(List<Integer> list, Node root) {
        // Если вершина указывает на Null выходим, т.е. возвращаемся к предыдущей итерации
        if (root == null) {
            return;
        }
        // иначе добавим значение вершины в наш список
        list.add(root.val);
        // переберем все дочерние элементы данной вершины
        for (Node node : root.children) {
            // Рекурсивно вызываем этот же метод
            // и так пока не переберем все дочерние элементы этой вершины, каждый из которых
            //переберет свои дочернии элементы
            // и так пока не обойдем все вершины
            createList(list, node);
        }
    }

}
