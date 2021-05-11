package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 */
public class Solution783 {
    private List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        inorder(root);
        for (int i = 0; i < list.size() - 1 ; i++) {
            int diff = Math.abs(list.get(i) - list.get(i + 1));
            min = Math.min(diff, min);
        }
        return min;
    }
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}
