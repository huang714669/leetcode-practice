package breadthFirstSearch;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Solution103 {
    public static void main(String[] args) {
        Solution103 sol = new Solution103();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = new TreeNode(4);
        node3.right = new TreeNode(5);
        List<List<Integer>> ans = sol.zigzagLevelOrder(node1);
        System.out.println(ans.toString());
    }

    /**
     * 使用bfs，每层逆序存入双端队列
     *
     * @param root
     * @return
     */
    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> levelData = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (isOrderLeft) {
                    levelData.offerLast(curNode.val);
                } else {
                    levelData.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }

            }
            ans.add(new LinkedList<Integer>(levelData));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
