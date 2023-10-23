package lesson2;

/**Дано бинарное дерево, нужно найти и вернуть элемент, находящийся на максимальной глубине от корня.*/
public class DeepestNode {
    public static class Node {
        int val;
        Node left;
        Node right;
    }

    public Node getDeepestNode(Node root) {
        int depth = maxDepth(root);
        return findDeepestNode(root, depth);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    private Node findDeepestNode(Node node, int depth) {
        if (node == null) {
            return null;
        }
        if (depth == 1) {
            return node;
        }
        Node left = findDeepestNode(node.left, depth - 1);
        if (left != null) {
            return left;
        }
        return findDeepestNode(node.right, depth - 1);
    }
}