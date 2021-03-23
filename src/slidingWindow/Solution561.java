package slidingWindow;

import java.util.Arrays;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * <p>
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-partition-i
 */
public class Solution561 {
    public static void main(String[] args) {
        Solution561 sol = new Solution561();
        int[] nums = {1, 4, 3, 2};
        int ans = sol.arrayPairSum(nums);
        System.out.println(ans);
    }

    /**
     * 解法： 先排序，然后各一个数字取一个加入sum
     * @param nums
     * @return
     */
    private int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length ; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
