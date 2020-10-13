package array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 */
public class Solution35 {
    public static void main(String[] args) {
        Solution35 sol = new Solution35();
        int[] nums = new int[]{1,2,4,6,7};
        int target = 3;
        int ans = sol.searchInsert(nums, target);
        System.out.println(ans);
    }

    /**
     * 使用二分法解题，如果left + 1 = right and left < target and right > target， 说明目标不存在数组中，返回left下标+1
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 边界条件
        if (len == 0 || target < nums[0]) {
            return 0;
        }
        if (target > nums[len - 1]) {
            return len;
        }
        // 二分法套路
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (left == right || left + 1 == right) {
                if (nums[left] >= target) {
                    return left;
                } else if (nums[right] < target){
                    return right + 1;
                } else {
                    return left + 1;
                }
            }
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
