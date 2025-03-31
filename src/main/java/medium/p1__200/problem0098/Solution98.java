package medium.p1__200.problem0098;

import static org.junit.Assert.assertEquals;

import common.TreeNode;
import common.TreeUtils;
import java.util.Arrays;

public class Solution98 {
    private static TreeNode root;

    public static boolean isValidBSTTest(TreeNode root) {
        return isValidBST(root);
    }

    public static void main(String[] args) {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertEquals(true, isValidBST(root));

        root = new TreeNode(0);
        assertEquals(true, isValidBST(root));

        root = new TreeNode(1);
        root.left = new TreeNode(1);
        assertEquals(false, isValidBST(root));

        root = TreeUtils.constructBinaryTree(Arrays.asList(5, 1, 7, null, null, 3, 8));
        TreeUtils.printBinaryTree(root);
        assertEquals(false, isValidBST(root));

        //
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertEquals(true, isValidBSTTest(root));

        root = new TreeNode(0);
        assertEquals(true, isValidBSTTest(root));

        root = new TreeNode(1);
        root.left = new TreeNode(1);
        assertEquals(false, isValidBSTTest(root));

        root = TreeUtils.constructBinaryTree(Arrays.asList(5, 1, 7, null, null, 3, 8));
        assertEquals(false, isValidBSTTest(root));
    }

    public static boolean isValidBST(TreeNode root) {
        // Необходимо проверить, что двоичное дерево валидно
        // т.е. в левом поддереве ключи должны быть строго меньше, а в правом строго больше
        // Алгоритм решения следующий определим диапазоны возможных значений для каждого поддерева
        // [Integer.MIN_VALUE, Integer.MAX_VALUE] диапазоны возможных значений для корня
        // root.val - реальное значение корня
        // [Integer.MIN_VALUE, root.val - 1] диапазоны возможных значений для левой части
        // [root.val + 1, Integer.MAX_VALUE] диапазоны возможных значений для правой части
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValid(TreeNode node, Integer min, Integer max) {
        // Если ветка пустая, то возвращаем, что дерево валидное
        if (node == null)
            return true;
        // Будем исходить от обратного, т.е. найдем все варианты когда дерево может быть не
        // валидным, а в противном случае - оно валидно
        // Если значение не находится в пределаз разрешенного диапазаона
        if (!(node.val >= min && node.val <= max))
            return false;
        // Проверим MAX и MIN чтобы не выйти за границы диапазона
        // Если значение кореня дерева = самому минимальному числу диапазоно, и при этом левый
        // дочерний узел не равен null
        if ((node.val == Integer.MIN_VALUE) && (node.left != null))
            return false;
        // Аналогичная проверка для правого узла
        if ((node.val == Integer.MAX_VALUE) && (node.right != null))
            return false;
        // Если значение корня не на нижнейгранице диапазаона, то проверим левую ветку,
        // запустив рекурсивно наш метод
        if ((node.val != Integer.MIN_VALUE) && (!isValid(node.left, min,node.val - 1)))
            return false;
        // Если значение корня не на верхней границе диапазаона, то проверим правую ветку,
        // запустив рекурсивно наш метод
        if ((node.val != Integer.MAX_VALUE) && (!isValid(node.right, node.val + 1, max)))
            return false;
        // Все проверки пройдены - дерево валидное
        return true;
    }

}
