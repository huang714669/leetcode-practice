package slidingWindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
public class Solution209 {
    public static void main(String[] args) {
        Solution209 sol = new Solution209();
        int s = 11;
        int[] nums = {1, 2, 3, 4, 5};
        int ans = sol.minSubArrayLen1(s, nums);
        System.out.println(ans);
    }

    /**
     * (此方法看错题目,该解法是恰好等于s)
     * 解法： 使用头尾指针法
     * 指针内的数据和小于s，右指针前进
     * 指针内的数据和大于s，左指针前进
     * 指针内的值等于s，记录左右指针位置，并将左右指针中间数据的长度作为备选结果，最终取最小值，然后右指针前进
     * 终止条件，右指针到达重点，而左右之间的和小于s
     *
     * @param s
     * @param nums
     * @return
     */
    private int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, sum = nums[0], minLen = Integer.MAX_VALUE;
        while (left <= right && right < len) {
            // sum小于s, 右指针需要前进
            if (sum < s) {
                if (right == len - 1) {
                    break;
                }
                right++;
                sum += nums[right];
            } else if (sum > s) {
                if (left == len - 1) {
                    break;
                }
                if (left == right) {
                    // 该字符大于s，双指针直接往前走， sum置为后一个数
                    left++;
                    right++;
                    sum = nums[left];
                } else {
                    // sum超了，左指针前进，sum减少
                    sum -= nums[left];
                    left++;
                }

            } else {
                // sum正好满足，记录左右指针之间的length，并和minLen比较替换
                minLen = Math.min(minLen, right - left + 1);
                if (right == len - 1) {
                    break;
                }
                // 右指针继续右移
                right++;
                sum += nums[right];
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            // 没有符合的解，返回0
            return 0;
        }
        return minLen;
    }

    private int minSubArrayLen1(int s, int[] nums) {
        int len = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, sum = nums[0], minLen = Integer.MAX_VALUE;
        while (left <= right && right < len) {
            if (sum >= s) {
                // 符合条件
                if (left == right) {
                    return 1;
                }
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            } else {
                if (right == len - 1) {
                    break;
                }
                right++;
                sum += nums[right];
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            // 没有符合的解，返回0
            return 0;
        }
        return minLen;
    }

}
