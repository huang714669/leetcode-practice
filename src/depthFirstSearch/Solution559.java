package depthFirstSearch;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 */
public class Solution559 {
    /**
     * bfs
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if (!curNode.children.isEmpty()) {
                    for (Node child : curNode.children) {
                        queue.offer(child);
                    }
                }
            }
        }
        return depth;
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            LinkedList<Integer> heights = new LinkedList<>();
            for (Node child : root.children) {
                heights.add(maxDepth1(child));
            }
            return Collections.max(heights) + 1;
        }

    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

;
