package offer;

import utils.TreeNode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 *
 *
 *
 */
public class Offer07 {
    public static void main(String[] args) {
        Offer07 sol = new Offer07();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode ans = sol.buildTree(preorder, inorder);
    }
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] pre;
    /**
     * preorder 第一个数是父节点，inorder中父节点左右两边分别是左子树和有字数
     * 同时preorder除去第一个节点后，左子树节点的数量和inorder一样
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len <= 0) {
            return null;
        }
        pre = preorder;
        // 使用备忘录记录inorder个元素的下标
        for (int i = 0; i < len ; i++) {
            memo.put(inorder[i], i);
        }
        return dfs(0, len - 1, 0, len - 1);
    }

    /**
     * 使用递归
     * @param pl preorder左边下标
     * @param pr preorder右边下标
     * @param il inorder左边下标
     * @param ir inorder右边下标
     * @return
     */
    private TreeNode dfs( int pl, int pr, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }
        // inorder第一个节点为head节点
        int root = pre[pl];
        TreeNode head = new TreeNode(root);
        // 查找head在inorder的位置
        int mid = memo.get(root);
        // 左子树
        head.left = dfs(pl + 1, pl + mid - il,il,mid - 1);
        // 右子树
        head.right = dfs(pl + mid - il + 1, pr,mid + 1, ir);
        // 最终返回head
        return head;
    }
}
