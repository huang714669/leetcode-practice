package array;

/**
 * @program: leetcode-practice
 * @description: remove target element on array
 * @author: Mr.Wang
 * @create: 2020-05-19 15:03
 **/
public class Solution27 {
    public static void main(String[] args) {
        Solution27 solution26 = new Solution27();
        int[] nums = {3, 2, 2, 3};
        int ans = solution26.removeElement(nums, 2);
        System.out.println(ans);
    }

    /**
     * 使用双指针法，定义两个指针p q，p指向第一个位置0,q指向位置1
     * 如果val==nums[q],q继续右移
     * 如果val!=nums[q],将nums[p+1]的值设为nums[q],并且p右移一位
     * q走到终点，则p+1即为不重复数组的长度
     *
     * @param nums
     * @return
     */
    private int removeElement(int[] nums, int val) {
        int p = 0, q = 0, len = nums.length;
        if (len < 0) return len;
        while (q < len && p < len) {
            if (nums[q] != val) {
                nums[p] = nums[q];
                p++;
            }
            q++;
        }
        return p;
    }
}
