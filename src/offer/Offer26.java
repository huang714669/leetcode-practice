package offer;

import utils.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // B是A的子树或者B是A.left的子树，或者B是A.right的子树，满足条件
        return (A != null && B != null) && (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * @param A
     * @param B
     * @return
     */
    private boolean dfs(TreeNode A, TreeNode B) {
        // B完全匹配成功
        if (B == null) {
            return true;
        }
        // A查找完还未匹配成功
        if (A == null || A.val != B.val) {
            return false;

        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
