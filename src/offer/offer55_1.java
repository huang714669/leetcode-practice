package offer;

import utils.TreeNode;

/**
 * @author hzh
 * @version 1.0
 * @date 2021/3/26 上午11:06
 */
public class offer55_1 {
    public static void main(String[] args) {
        offer55_1 sol = new offer55_1();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node3.left = node9;
        node3.right = node20;
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        int ans = sol.maxDepth(node3);
        System.out.println(ans);
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0, rightDepth = 0;
        leftDepth = maxDepth(root.left);
        rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
