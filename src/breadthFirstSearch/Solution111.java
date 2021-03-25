package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Solution111 {

    public static void main(String[] args) {
        Solution111 sol = new Solution111();
        int[] nums = new int[]{3, 9, 20, 1, 1, 15, 17};
        TreeNode root = sol.buildBinaryTree(new TreeNode(), nums, 1);
        int depth = sol.minDepth(root);
        System.out.println(depth);
    }

    /**
     * 最小路径，典型的bfs解法， 使用队列
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //初始化队列,并加入root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //初始化深度为1
        int depth = 1;
        //遍历队列每个节点如果有子节点，则加入对尾
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                //从队头开始取出队列当前层所有节点
                TreeNode cur = queue.poll();
                //判断是否到达重点
                if (cur.left == null && cur.right ==null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // 用数组建立普通二叉树
    public TreeNode buildBinaryTree(TreeNode root, int[] A, int index) {
        if (index > A.length / 2) {
            return root;
        }
        if (index == 1) {
            root.val = A[0];
        }
        root.left =  new TreeNode(A[index * 2 - 1]);
        buildBinaryTree(root.left, A, index + 1);
        root.right = new TreeNode(A[index * 2]);
        buildBinaryTree(root.right, A, index + 2);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode () {

    }
}
