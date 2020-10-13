package array;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 */
public class Solution724 {
    public static void main(String[] args) {
        Solution724 sol = new Solution724();
        int[] nums = new int[]{1};
        int ans = sol.pivotIndex(nums);
        System.out.println(ans);
    }

    /**
     * 解法一：暴力求解，直接从头遍历，遇到第一个符合条件的就返回index
     * @param nums
     * @return
     */
    private int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int leftSum = 0, rightSum = 0;
        for (int num: nums) {
            rightSum += num;
        }
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                leftSum += nums[i - 1];
            }
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
