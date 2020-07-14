package hashTable;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {
    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        sol.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        //将数字存入hashmap,查询的复杂度为o(1)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.printf("nums[0] is %d, nums[1] is %d", i, map.get(complement));
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
