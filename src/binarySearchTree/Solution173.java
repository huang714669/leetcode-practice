package binarySearchTree;

import java.util.ArrayList;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 */
public class Solution173 {
    // 使用数组存储二叉树的中序遍历结果
    private ArrayList<Integer> sortedNodes;
    // 使用数字存储下标
    int index;

    // 在构造函数中构造有序数组
    public Solution173(TreeNode root) {
        this.sortedNodes = new ArrayList<>();
        dfs(root);
        index = 0;
    }

    public int next() {
        return this.sortedNodes.get(index++);
    }

    // 中序遍历
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        this.sortedNodes.add(node.val);
        dfs(node.right);
    }

    public boolean hasNext() {
        return this.index < this.sortedNodes.size();
    }
}
