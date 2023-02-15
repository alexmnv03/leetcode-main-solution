package medium.p1__200.problem0102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Если это новый уровень то создаем новый список и выходим
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        // Создаем очередь в которой будут хранениться все узлы текущего уровня
        Queue<TreeNode> queue = new LinkedList<>();
        // Добавим корневой узел в конец очереди, он будет извлечен первым
        queue.add(root);
        // перебираем все узлы очереди, пока
        while(!queue.isEmpty()) {
            // Создаем новый список для текущего уровня
            List<Integer> listTree = new ArrayList<>();
            // Получи кол-во узлов на данном уровне
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                // Получаем первый узел очереди и удаляем его из нее
                TreeNode currNode = queue.poll();
                // и добавим его в список
                listTree.add(currNode.val);
                // Т.к. обход делаем слева на право, то первым добавляем левый дочерний узел
                // Таким образом формуруем список узлов следующего уровня
                // Если узел имеет левый дочерний узел, то добавим его в очередь
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                // Если узел имеет правый дочерний узел, то добавим его в очередь
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            // Уровень пройден, добавим список его узлов в общий
            list.add(listTree);
        }
        return list;
    }

}
