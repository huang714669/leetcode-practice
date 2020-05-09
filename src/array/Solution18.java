package array;

import java.util.*;

/**
 * @program: leetcode-practice
 * @description: the sum of four  numbers
 * @author: Mr.Huang
 * @create: 2020-05-09 10:53
 **/
public class Solution18 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        Solution18 solution18 = new Solution18();
        List<List<Integer>> ans = solution18.fourSum(nums, target);
        System.out.println("ans"+ans.toString());
    }

    /**
     * 参考three-sum两题的解法，直接使用四指针的解法，降低复杂度
     * @param nums
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (length < 4 || nums == null) return  ans;
        //先排序
        Arrays.sort(nums);
        //定义k, i, j, h四个指针，k从0开始, i从k+1开始，j从i+1开始，h从len-1开始，遍历k，i，j，h就组成了三数之和的解法，j和h就是三数之和的双指针
        for (int k = 0; k < length - 3; k++) {
            //当值与前值相等，忽略
            if (k > 0 && nums[k] == nums[k-1]) continue;
            //如果最小的四个值大于target说明后面的值都没戏。直接跳出循环
            int min = nums[k] + nums[k+1] + nums[k+2] + nums[k+3];
            if (min > target) break;;
            //如果最大的四个值小于target，跳出本轮循环
            int max = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max < target) continue;
            //进行第二轮循环， 简化为三数相加，第一个数位i, j和h为左右指针，寻找合适解
            for (int i = k + 1; i < length - 2; i++) {
                //如果i的值与前值相等，跳出本轮循环
                if (i > k + 1 && nums[i] == nums[i-1]) continue;
                //初始化左右指针
                int j = i + 1;
                int h = length -1;
                //获取最小值，target
                int min1 = nums[k] + nums[i] +nums[j] +nums[j+1];
                if (min1 > target) break;
                //获取最大值，比target小则跳出本轮循环
                int max1 = nums[k] + nums[i] + nums[h] + nums[h-1];
                if (max1 < target) continue;
                //双指针逼近算法
                while (j < h) {
                    //如果和为target，则满足条件
                    int sum = nums[i] + nums[k] + nums[j] + nums[h];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        h--;
                        //移动重复指针
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    }
                    //否则，移动左右指针
                    else if (sum > target) {
                        h--;
                    } else {
                        j++;
                    }
                }

            }
        }
        return  ans;
    }
}
