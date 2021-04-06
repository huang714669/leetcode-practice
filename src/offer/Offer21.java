package offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Offer21 {
    public static void main(String[] args) {
        Offer21 sol = new Offer21();
        int[] nums = {1, 2, 3, 4,8,4,12,678,21,5,35,77,568,212};
        int[] ans = sol.exchange(nums);
        System.out.println(Arrays.toString(ans)); //  {1,3,2,4}
    }

    // 双指针快慢指针法，慢指针记录的位置左边都是奇数
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int i = 0;
        for (int j = 0; j < len; j++) {
            // 如果是奇数i,j交换且i右移
            if (nums[j] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return nums;
    }
}
