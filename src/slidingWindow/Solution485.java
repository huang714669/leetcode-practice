package slidingWindow;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 */
public class Solution485 {
    public static void main(String[] args) {
        Solution485 sol = new Solution485();
        int[] nums = {};
        int ans = sol.findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }

    /**
     * 解法： 使用快慢指针法
     * 快指针，每次往前走一步；慢指针，只有快指针走到0时，走到快指针位置
     * 使用sum变量记录最大连续1个数，当快指针走到1时，记录快慢指针之差，并更新sum值，重复这个步骤直到遍历结束
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0, quick = -1, slow = -1;
        for (int i = 0; i < nums.length ; i++) {
            quick++;
            if (nums[i] == 0) {
                sum = Math.max(sum, quick - slow - 1);
                slow = quick;
            }
        }
        // 处理右边界是1的情况
        sum = Math.max(sum, quick - slow);
        return  sum;
    }
}
