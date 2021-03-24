package hashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Solution217 {
    public static void main(String[] args) {
        Solution217 sol = new Solution217();
        int[] nums = new int[]{1, 2, 3, 1};
        boolean ans = sol.containsDuplicate2(nums);
        System.out.println(ans);
    }

    // 使用HashMap
    private boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }

    // 使用HashSet
    private boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) {
                return true;
            };
        }
        return false;
    }
}
