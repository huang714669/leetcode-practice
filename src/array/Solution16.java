package array;

import java.util.Arrays;

/**
 * @program: leetcode-practice
 * @description: leetcode 16: the closet  sum value of three numbers
 * @author: Mr.Huang
 * @create: 2020-05-07 11:11
 * @Category: double pointers
 **/
public class Solution16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = new int[]{13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1, -15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9, 0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10, 1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7, 0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6};
        int target = -59;
        int ans = solution16.threeSumCloset(nums, target);
        System.out.println(ans);
    }

    /**
     * 思路和15题类似，区别是使用全局变量表示和target的最小差值
     *
     * @param nums
     * @param target
     * @return
     */
    private int threeSumCloset(int[] nums, int target) {
        if (nums.length < 3) throw new IllegalArgumentException("the length of nums must greater or equal than 3");
        int minDiff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int res = nums[0] + nums[1] + nums[2];
        //先对nums进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int diff = Math.abs(nums[i] + nums[left] + nums[right] - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    res = nums[i] + nums[left] + nums[right];
                } else if (nums[i] + nums[left] + nums[right] - target > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] - target < 0) {
                    left++;
                } else {
                    //与taret相等，可以直接返回
                    return res;
                }
            }
        }
        return res;
    }
}
