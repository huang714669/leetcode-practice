package binarySearchTree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class Solution450 {
    /**
     * 步骤： 先找到节点，在执行删除动作
     * 删除节点有三种情况
     * 1. 该节点没有子节点，直接删除
     * 2. 该节点只有一个子节点，则删除该节点用子节点替代
     * 3. 该节点有两个节点，则用该节点右子树最小节点替代（或左子树最大节点）
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // delete from the right subtree
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // delete from the left subtree
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) {
                root = null;
            }
            // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

}
