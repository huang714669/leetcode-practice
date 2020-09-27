package tree;

import utils.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 */
public class Solution104 {
    private int maxDepth = 0;

    //递归，使用前序遍历
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }
    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
