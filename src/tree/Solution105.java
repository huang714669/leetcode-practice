package tree;

import utils.TreeNode;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
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
 * 来源：力扣（LeetCode）
 */
public class Solution105 {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    int [] pre;
    /**
     * 规律：
     * 1. preOrder第一个节点为根节点
     * 2. inOrder中，根节点左边是左子树，右边是右子数，所以找到根节点的所以可以划分左右子树
     * 3. preOrder中， 左右子树的数量恰好是inOrder根节点左边节点的数量
     * 解法： 使用递归，每次根据preOrder第一位寻找根节点，再分别构造该节点前序和后续的左右子树
     * 变量: is, ie, ps, pe, idx分别表示inOrder左右下标，preOrder左右下标，和该轮递归根节点在inOder中的下标
     *
     * @param inorder
     * @param preorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length ; i++) {
            memo.put(inorder[i], i);
        }
        pre = preorder;
        TreeNode root = treeHelper(0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    public TreeNode treeHelper(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        int root = pre[ps];
        int idx = memo.get(root);
        TreeNode node = new TreeNode(root);
        node.left = treeHelper(is, idx-1, ps + 1, ps + idx -is);
        node.right = treeHelper(idx + 1, ie, ps + idx -is + 1, pe);
        return node;
    }
}
