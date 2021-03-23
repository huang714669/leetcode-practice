package tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution94 {
    List<Integer> list = new LinkedList<>();

    // 方法一 基于dfs的递归
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    //方法二 迭代, 基于栈
    public List<Integer> inorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}