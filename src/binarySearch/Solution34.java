package binarySearch;

public class Solution34 {
    public static void main(String[] args) {
        //输入: nums = [5,7,7,8,8,10], target = 8
        //输出: [3,4]
        Solution34 sol = new Solution34();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] ans = sol.searchRange(nums, target);
        System.out.println(ans[1]);
    }

    //方法一，二分法, 复杂度ologn
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }
    //左边界二分法套路
    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] > target ) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target ) {
                //右边界左移
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return  -1;
        }
        return left;
    }
    //右边界二分法套路
    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] > target ) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target ) {

                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return  -1;
        }
        return right;
    }
}
