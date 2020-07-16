package binarySearch;

public class Solution704 {
    // nums = [-1,0,3,5,9,12], target = 9
    public static void main(String[] args) {
        Solution704 sol = new Solution704();
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        int ans = sol.search(nums, target);
        System.out.println(ans);
    }

    /**
     * 基本二分法搜索，直接套代码
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] > target) {
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return  -1;
    }
}
