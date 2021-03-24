package offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 */
public class Offer53 {
    public static void main(String[] args) {
        Offer53 sol = new Offer53();
        int[] nums = new int[]{0,1,3};
        int ans = sol.missingNumber(nums);
        System.out.println(ans);
    }

    // 二分法, 左子数组，nums[i] = i, 右子数组 nums[i] != i,缺省值就是右子数组第一个数减1
    private int missingNumber(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == mid) {
                // 缺省值在左边
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
