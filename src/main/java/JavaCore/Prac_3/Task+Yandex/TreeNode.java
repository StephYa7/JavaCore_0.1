package lesson3;

/**
 * Найти ближайшего общего предка двух узлов дерева.
 * Ограничение по памяти: O(1)
 */
public class TreeNode {
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode parent, TreeNode left, TreeNode right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public TreeNode lowestCommonAncestor(TreeNode first, TreeNode second) {
        return null;
    }
}
