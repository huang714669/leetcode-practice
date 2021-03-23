package tree;

import utils.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 */
public class Solution101 {
    /**
     * 方法一 递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    /**
     * 比较两个节点是否对称
     * @param node1
     * @param node2
     * @return
     */
    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        //两节点子树对称条件： 1.两节点值相等 2.node1.left和node2.right对称, 3. node1.right和node2.left对称
        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }


}
