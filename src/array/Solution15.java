package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = solution15.threeSum(nums);
        System.out.println(ans);
    }

    /**
     * 解题思路：
     * 1. 先对数组进行排序，复杂度为nlogn
     * 2. 从头遍历数组每个值，采用双指针法， 寻找满足条件的值 复杂度n^2
     * 3. 指针移动的时候注意跳过重复的值
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums); //对数组先进行排序
        for (int i = 0; i < nums.length; i++) {
            //如果i为的值已经大于0，没必要比较后续的值，直接返回结果
            if (nums[i] > 0) return ans;
            //如果跟前一个值重复，跳过此次循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1; //初始化左右指针
            while (left < right) {
                //如果满足条件
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> values = new ArrayList<>();
                    values.add(nums[i]);
                    values.add(nums[left]);
                    values.add(nums[right]);
                    ans.add(values);
                    //如果左边指针重复， 左边指针右移
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //如果右边指针重复，右边指针左移
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                //否则，大于目标值，右边指针左移
                else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return ans;
    }


}
