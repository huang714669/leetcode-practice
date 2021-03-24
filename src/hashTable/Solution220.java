package hashTable;

import java.util.TreeSet;

/**
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class Solution220 {
    public static void main(String[] args) {
        Solution220 sol = new Solution220();
        int[] nums = new int[]{2147483640,2147483641};
        int k = 1;
        int t = 100;
        boolean ans = sol.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(ans);
    }

    /**
     * 暴力求解发可以通过一直维护一个包含k个元素的的双指针查看内部有没有差值小于t的元素，但是复杂度高
     * 本地使用二叉搜索树解法，对应TreeSet数据结构
     * 树中最多保存k个元素，每次插入前查找最接近值，如果差值小于t，则返回true
     */
    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 查找比num大的最近的数
            Long ceiling = set.ceiling(Long.valueOf(nums[i]));
            if (ceiling != null && ceiling <= t + nums[i]) {
                return true;
            }
            // 查找比num小的最近的数
            Long floor = set.floor(Long.valueOf(nums[i]));
            if (floor != null && nums[i] <= t + floor) {
                return true;
            }
            // 加入此元素
            set.add(Long.valueOf(nums[i]));
            // 如果set元素超过k，则删除最早加入的元素
            if (set.size() > k) {
                set.remove(Long.valueOf(nums[i - k]));
            }
        }
        return false;
    }
}
