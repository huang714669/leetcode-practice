package offer;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hzh
 * @version 1.0
 * @date 2021/3/26 上午10:28
 */
public class Offer32_1 {
    public static void main(String[] args) {
        Offer32_1 sol = new Offer32_1();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node3.left = node9;
        node3.right = node20;
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        int[] ans = sol.levelOrder(node3);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * bfs
     * @param root
     * @return
     */
    private int[] levelOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode curData = queue.poll();
                list.add(curData.val);
                if (curData.left != null) {
                    queue.offer(curData.left);
                }
                if (curData.right != null) {
                    queue.offer(curData.right);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
