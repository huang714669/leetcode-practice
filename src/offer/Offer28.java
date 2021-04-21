package offer;

import utils.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    /**
     * 比较node1和node2是否对称
     *
     * @param node1
     * @param node2
     * @return
     */
    public boolean dfs(TreeNode node1, TreeNode node2) {
        // 同时搜索到结尾，是对称
        if (node1 == null && node2 == null) {
            return true;
        }
        // 有一个先到结尾，不对称
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val) && dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }
}
