package slidingWindow;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
public class Solution80 {
    public static void main(String[] args) {
        Solution80 sol = new Solution80();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int ans = sol.removeDuplicates(nums);
        char i = '5';
        System.out.println(ans);
    }

    /**
     * 使用双指针求解
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // i为慢指针，j为快指针
        int i = 0, j;
        // 记录i，j之间重复的个数
        int dups = 0;
        for (j = 1; j < len; j++) {
            // 不相等，左指针右移一位，且该位置设为nums[j],dups重设为0
            if (nums[i] != nums[j]) {
                i++;
                dups = 0;
                nums[i] = nums[j];
            } else if (dups < 1) {
                i++;
                dups++;
                nums[i] = nums[j];
            } else {
                dups++;
            }
        }
        return i + 1;
    }
}
