package utils;

public class TreeUtils {
    // 用数组建立普通二叉树
    public static TreeNode buildBinaryTree(TreeNode root, int[] A, int index) {
        if (index > A.length / 2) {
            return root;
        }
        if (index == 1) {
            root.val = A[0];
        }
        root.left =  new TreeNode(A[index * 2 - 1]);
        buildBinaryTree(root.left, A, index + 1);
        root.right = new TreeNode(A[index * 2]);
        buildBinaryTree(root.right, A, index + 2);
        return root;
    }
}
