package offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 */
public class Offer33 {
    public static void main(String[] args) {
        Offer33 sol = new Offer33();
        int[] nums = {5, 4, 3};
        boolean ans = sol.verifyPostorder(nums);
        System.out.println(ans);
    }

    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        return dfs(postorder, 0, len - 1);
    }

    /**
     * 后续遍历，最后一个数字一定是header节点
     * 取出header节点，从前往后遍历，知道遇到比header值大的点mid，则该点左侧都是左子树
     * 遍历mid后面的点，如果小于mid点的值，则不符合右子树比header大的定义，返回false
     * 继续递归左子树和右子树，要求都满足以上条件
     * @param nums
     * @param i 左侧指针
     * @param j 右侧指针
     * @return
     */
    private boolean dfs(int[] nums, int i, int j) {
        // 指针碰撞，遍历完成，符合要求
        if (i >= j) {
            return true;
        }
        int p = i;
        // 最后一个节点是头结点
        int header = nums[j];
        // 左子树都是比头结点小
        while (nums[p] < header) {
            p++;
        }
        int mid = p;
        // i节点以后的应该是右子树，都比nums[i]大, p最终应该为j
        while (nums[p] > nums[j]) {
            p++;
        }
        // 左右子树都是二叉搜索树
        return p==j && dfs(nums, i, mid - 1) && dfs(nums, mid, j - 1);
    }

}
