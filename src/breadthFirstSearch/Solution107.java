package breadthFirstSearch;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 *
 */
public class Solution107 {
    public static void main(String[] args) {
        Solution107 sol = new Solution107();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node3.left = node9;
        node3.right = node20;
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        List<List<Integer>> ans = sol.levelOrderBottom2(node3);
        System.out.println(ans.toString());
    }
    /**
     * 使用bfs，但是每层遍历结果放入栈中，最后依次弹出到list结果
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<List<Integer>> stack = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelData = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                TreeNode node = queue.poll();
                levelData.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(levelData);
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    /**
     * 使用bfs，但是每层遍历结果放入双端队列中
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Deque<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return (List)ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelData = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                TreeNode node = queue.poll();
                levelData.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.addFirst(levelData);
        }
        return (List)ans;
    }
}
