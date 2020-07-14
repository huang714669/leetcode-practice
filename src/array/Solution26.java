package array;

/**
 * @program: leetcode-practice
 * @description: remove duplicates on array
 * @author: Mr.Wang
 * @create: 2020-05-19 15:03
 **/
public class Solution26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int ans = solution26.removeDuplicates(nums);
        System.out.println(ans);
    }

    /**
     * 使用双指针法，定义两个指针p q，p指向第一个位置0,q指向位置1
     * 如果nums[p]==nums[q],q继续右移
     * 如果nums[p]!=nums[q],将nums[p+1]的值设为nums[q],并且p右移一位
     * q走到终点，则p+1即为不重复数组的长度
     *
     * @param nums
     * @return
     */
    private int removeDuplicates(int[] nums) {
        int p = 0, q = 1, len = nums.length;
        if (len < 2) return len;
        while (q < len) {
            if (nums[q] != nums[p]) {
                nums[++p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}
