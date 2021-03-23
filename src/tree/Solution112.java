package tree;

import utils.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, root.val, sum);
    }
    // 基于dfs的前序遍历
    public boolean dfs(TreeNode node, int cur, int sum) {
        // 空节点不是叶子节点
        if (node == null) {
            return false;
        }
        // 叶子节点
        if (node.left == null && node.right == null) {
            return cur == sum;
        }
        // 只有右节点
        if (node.left == null) {
            return dfs(node.right, cur + node.right.val, sum);
        }
        // 只有左节点
        if (node.right == null) {
            return dfs(node.left, cur + node.left.val, sum);
        }
        // 左右节点都有，只有有一条路满足条件即可
        return dfs(node.left, cur + node.left.val, sum) || dfs(node.right, cur + node.right.val, sum);
    }
}
