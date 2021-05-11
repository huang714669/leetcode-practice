package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 */
public class Solution179 {
    public static void main(String[] args) {
        Solution179 sol = new Solution179();
        int[] nums = {3, 30, 34, 5, 9};
        String ans = sol.largestNumber(nums);
        System.out.println(ans);
    }

    /**
     * 比较两个数哪个放在前面，组合的数更大，重写Arrays.sort方法即可
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        int len = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[]  arrNums = new Integer[len];
        for (int i = 0; i < len ; i++) {
            arrNums[i] = nums[i];
        }
        Arrays.sort(arrNums, (x, y) -> {
            int sx =10, sy= 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int)y * sx + x - x * sy - y;
        });
        if (arrNums[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : arrNums) {
            ret.append(num);
        }
        return ret.toString();
    }
}
