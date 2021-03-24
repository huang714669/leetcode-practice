package binarySearchTree;

import sun.reflect.generics.tree.Tree;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 * 解释：另一个满足题目要求可以通过的树是：
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 * 示例 3：
 * <p>
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 *  
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 */
public class Solution701 {

    /**
     * 二叉搜索树插入肯定是插入叶子节点
     * 如果插入值比节点值大，且右侧节点为空，则直接插入右侧节点，否则继续寻找右侧节点
     * 如果插入值比节点值小，且左侧节点为空，则直接插入左侧节点，否则继续寻找左侧节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode p = root;
        TreeNode insertNode = new TreeNode(val);
        if (root == null) {
            return insertNode;
        }
        while (p != null) {
            if (p.val > val) {
                if (p.left == null) {
                    p.left = insertNode;
                    break;
                } else {
                    p = p.left;
                }
            }
            if (p.val < val) {
                if (p.right == null) {
                    p.right = insertNode;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        return root;
    }
}
