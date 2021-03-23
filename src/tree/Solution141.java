package tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 来源：力扣（LeetCode）
 */
public class Solution141 {
    public static void main(String[] args) {
        Solution141 solution141 = new Solution141();
//        int[] nums = {1, ,2,3}; 此题不好构建二叉树，就直接写方法了
    }
    private List<Integer> list = new LinkedList<>();
    /**
     * 解法一 基于DFS的递归方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    /**
     * 解法二： 基于栈的迭代方法
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            list.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return list;
    }

    /**
     * dfs
     */
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

}
